package io.u2ware.ocpp;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.ConnectionLostException;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class OCPPSessionTemplate<T extends OCPPCommand> extends TextWebSocketHandler implements StompSessionHandler, ApplicationContextAware{

    protected final Log logger = LogFactory.getLog(getClass());

    protected Map<String, WebSocketSession> webSocketSessions = new HashMap<>();
    protected Map<String, StompSession> stompSessions = new HashMap<>();

    protected OCPPConversion conversion = new OCPPConversion();
    protected ObjectMapper mapper = new ObjectMapper();

    protected ApplicationContext applicationContext;
    protected OCPPHandlerOperations<T> operations;
    protected SimpMessageSendingOperations simpOperations;


    protected OCPPSessionTemplate(OCPPHandlerOperations<T> operations, SimpMessageSendingOperations simpOperations) {
        Assert.notNull(operations, "operations");
        this.operations = operations;
        this.simpOperations = simpOperations;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String getFirstSessionId() {
        return webSocketSessions.keySet().stream().findFirst().get();
    }


    /////////////////////////////////////////////////////////////////////
    //  WebSocketHandler
    /////////////////////////////////////////////////////////////////////
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {       
        this.webSocketSessions.put(session.getId(), session);
        connect(session);
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        this.webSocketSessions.remove(session.getId());
        disconnect(session);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        error(session, "ERROR", exception);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage text) throws Exception {
        // System.err.println("handleTextMessage: "+text);
        // System.err.println("handleTextMessage: "+session);
        String received = text.getPayload();
        OCPPMessage<?> message = null;
        try{
            message = conversion.convertMessage(received);
        }catch(Exception e){
            error(session, "ERROR01",  e);
            return;
        }
        received(session, received);
        answer(session, message);
    }

    /////////////////////////////////////////////////////////////////////
    //  StompSessionHandler
    /////////////////////////////////////////////////////////////////////
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        this.stompSessions.put(session.getSessionId(), session);
        connect(session);
    }
    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        if(ClassUtils.isAssignableValue(ConnectionLostException.class, exception)) {
            this.stompSessions.remove(session.getSessionId());
            disconnect(session);
        }else{
            error(session, "ERROR", exception);
        }
    } 

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        error(session, "ERROR", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }
    @Override
    public void handleFrame(StompHeaders headers, Object payload) {

        String received = (String)payload;
        OCPPMessage<?> message = null;
        try{
            message = conversion.convertMessage(received);
        }catch(Exception e){
            error(null, "ERROR01",  e);
            return;
        }
        received(headers, received);
        answer("/app/channel", message);
    }    

    /////////////////////////////////////////////////////////////////////
    //  @MessageMapping
    /////////////////////////////////////////////////////////////////////
    @MessageMapping("channel")
    public void handleStompMessage(@Payload String payload){
        OCPPMessage<?> message = null;
        try{
            message = conversion.convertMessage(payload);
        }catch(Exception e){
            error(null, "ERROR01",  e);
            return;
        }
        received(simpOperations, payload);
        answer("/topic/channel", message);
    }

    @MessageMapping("channel.{id}")
    public void handleStompMessage(@DestinationVariable(value = "id") String id, @Payload String payload){

        if(webSocketSessions.containsKey(id)){
            WebSocketSession session = webSocketSessions.get(id);
            // System.err.println("handleStompMessage: "+payload);
            // System.err.println("handleStompMessage: "+session);
            
            T command = null;
            try{
                command = convert(payload);
                if(command == null) throw new NullPointerException("command");
            }catch(Exception e){
                e.printStackTrace();
                error(simpOperations, "ERROR01",  e);
                return;
            }
            offer(session, command);

        }else{
            error(simpOperations, "ERROR01",  new NullPointerException("session"));
        }
    }

    protected abstract T convert(String payload) throws Exception;

    /////////////////////////////////////////////////////////////////////
    //  
    /////////////////////////////////////////////////////////////////////
    protected void answer(WebSocketSession session, OCPPMessage<?> message) {
        OCPPMessage<?> m = appendSessionId(session, message);
        operations.answer(m, this.consumer(session));
    }
    protected void offer(WebSocketSession session, T command) {
        T c = appendSessionId(session, command);
        operations.offer(c, this.consumer(session));        
    }

    private OCPPMessageConsumer consumer(WebSocketSession session) {
        return (message,t)->{
            if(message == null && t == null) {
                return;
            }
            if(message == null && t != null) {
                error(session, "ERROR02",  t);
                return;
            }

            try{
                OCPPMessage<?> m = removeSessionId(session, message);
                String send = conversion.convertMessage(m);
                session.sendMessage(new TextMessage(send));
                send(session, send);
            }catch(Exception e){
                // e.printStackTrace();
                error(session, "ERROR03",  t);
                return;
            }
        };
    }

    /////////////////////////////////////////////////////////////////////
    //  
    /////////////////////////////////////////////////////////////////////
    protected void offer(String destination, T command) {
        operations.offer(command, this.consumer(destination));        
    }
    protected void answer(String destination, OCPPMessage<?> message) {
        operations.answer(message, this.consumer(destination));        
    }
    private OCPPMessageConsumer consumer(String destination) {

        return (message,t)->{
            if(message == null && t == null) {
                return;
            }
            if(message == null && t != null) {
                error(null, "ERROR02",  t);
                return;
            }
            try{
                String send = conversion.convertMessage(message);
                if(this.stompSessions.size() > 0) {
                    StompSession session = this.stompSessions.values().stream().findFirst().get();
                    session.send(destination, send);
                    send(session, send);
                } else{
                    simpOperations.convertAndSend(destination, send);
                    send(simpOperations, send);
                }

            }catch(Exception e){
                error(null, "ERROR03",  t);
                return;
            }
        };
    }

    /////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////
    private T appendSessionId(WebSocketSession session, T command){
        if(! command.getIdentifier().contains(session.getId())) {
            command.setIdentifier(command.getIdentifier()+""+session.getId());
        }
        return command;
    }
    // private T removeSessionId(WebSocketSession session, T command){
    //     if(command.getIdentifier().contains(session.getId())) {
    //         command.setIdentifier(command.getIdentifier().replace(session.getId(), ""));
    //     }
    //     return command;
    // }
    private OCPPMessage<?> appendSessionId(WebSocketSession session, OCPPMessage<?> message){
        if(! message.getId().contains(session.getId())) {
            message.setId(message.getId()+session.getId());
        }        
        return message;
    }
    private OCPPMessage<?> removeSessionId(WebSocketSession session, OCPPMessage<?> message){
        if(message.getId().contains(session.getId())) {
            message.setId(message.getId().replace(session.getId(), ""));
        }
        return message;
    }


    /////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////
    protected void connect(Object session){
        brodcast(session, "CONNECT", "{}");
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionConnectEvent(session));
    }
    protected void disconnect(Object session){
        brodcast(session, "DISCONNECT", "{}");
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionDisconnectEvent(session));
    }
    protected void error(Object session, String text, Throwable exception){
        brodcast(session, text, exception);
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionErrorEvent(session, text, exception));
    }
    protected void received(Object session, String text){
        brodcast(session, "RECEIVED", text);
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionReceivedEvent(session, text));        
    }
    protected void send(Object session, String text){
        brodcast(session, "SEND", text);
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionSendEvent(session, text));
    }

    /////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////
    private void brodcast(Object session, String action, Object resource){
        if(simpOperations == null) {
            if(ClassUtils.isAssignableValue(Throwable.class, resource)) {
                logger.info(action+": ", (Throwable)resource);
            }else{
                logger.info(action+": "+resource);
            }         
            return;
        }
        Object payload = createPayload(session, action, resource);
        simpOperations.convertAndSend("/topic/console", payload);
    }

    private String createPayload(Object session, String category, Object resource){

        try{
            System.err.println("createPayload: "+session);
            // System.err.println("createPayload: "+category);

            ObjectNode root = mapper.createObjectNode();
            root.put("category", category);

            if(ClassUtils.isAssignableValue(WebSocketSession.class, session)) {
                WebSocketSession ws = (WebSocketSession)session;

                ObjectNode target = mapper.createObjectNode();
                target.put("type", "WebSocketSession");
                target.put("id", ws.getId());
                target.put("localAddress", ws.getLocalAddress().toString());
                target.put("remoteAddress", ws.getRemoteAddress().toString());
                target.put("uri", ws.getUri().toString());
                target.put("acceptedProtocol", ws.getAcceptedProtocol().toString());
                root.set("target", target);

            }else if(ClassUtils.isAssignableValue(StompSession.class, session)) {
                ObjectNode target = mapper.createObjectNode();
                target.put("type", "StompSession");
                root.set("target", target);

            }else{
                root.set("target", null);
            }

            if(ClassUtils.isAssignableValue(Throwable.class, resource)) {
                Throwable t = (Throwable)resource;
                ArrayNode stack = mapper.createArrayNode();
                while(t != null) {
                    stack.add(t.toString());
                    t = t.getCause();
                }
                ObjectNode message = mapper.createObjectNode();
                message.set("exception", stack);
                root.set("message", message);


            }else if(ClassUtils.isAssignableValue(String.class, resource)) {
                String t = (String)resource;
                JsonNode message = mapper.readTree(t);
                root.set("message", message);
            }else{
                JsonNode message = mapper.convertValue(resource, JsonNode.class);
                root.set("message", message);
            }


            // return root;
            return mapper.writeValueAsString(root);
        }catch(Exception e) {
            e.printStackTrace();
            return "{}";
            // return mapper.createObjectNode();
        }
    }

}