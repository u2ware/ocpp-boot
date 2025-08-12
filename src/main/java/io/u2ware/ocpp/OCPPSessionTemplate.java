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
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
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
    protected String destination;


    protected OCPPSessionTemplate(OCPPHandlerOperations<T> operations, SimpMessageSendingOperations simpOperations) {
        Assert.notNull(operations, "operations");
        this.operations = operations;
        this.simpOperations = simpOperations;
    }

    protected OCPPSessionTemplate(String destination, OCPPHandlerOperations<T> operations, SimpMessageSendingOperations simpOperations) {
        Assert.hasText(destination,  "description");
        Assert.notNull(operations, "operations");
        this.operations = operations;
        this.simpOperations = simpOperations;
        this.destination = destination;
    }






    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String getFirstStandardSessionId() {
        return webSocketSessions.keySet().stream().findFirst().get();
    }
    public String getFirstStompSessionId() {
        return stompSessions.keySet().stream().findFirst().get();
    }

    /////////////////////////////////////////////////////////////////////
    //  WebSocketHandler (Both Server and Client)
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
        error(session, new RuntimeException("handleTransportError", exception));
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage payload) throws Exception {
        // System.err.println("receivedMessage By WebSocketHandler");

        String text = payload.getPayload();
        OCPPMessage<?> message = convertMessage(text);
        if(message == null) {
            error(session, new RuntimeException("handleTextMessage", new IllegalArgumentException(String.format("'%s'", text))));
            return;
        }        
        received(session, text);
        answer(session, message);
    }

    /////////////////////////////////////////////////////////////////////
    //  StompSessionHandler (Client Side)
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
            error(session, new RuntimeException("handleTransportError", exception));
        }
    } 

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        error(session, new RuntimeException("handleException", exception));
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {

        if(simpOperations == null) {
            error(headers, new RuntimeException("handleFrame",  new NullPointerException("simpOperations")));
            return;
        }

        String text = (String)payload;
        String id = convertDestination(headers);
        WebSocketSession websocket = webSocketSessions.get(id);
        OCPPMessage<?> message = convertMessage(text);
        T command = convertCommand(text);

        if(message == null && command == null) {
            error(headers, new RuntimeException("handleFrame", new IllegalArgumentException(String.format("'%s'", text))));
            return;
        }

        if(websocket != null) {
            if(command != null) {
                // System.err.println("receivedMessage By StompSessionHandler: 1");
                offer(websocket, command);
            }else if(message != null){
                // System.err.println("receivedMessage By StompSessionHandler: 2");
                received(headers, text);
                answer(websocket, message);
            }
        }else{
            if(command != null) {
                // System.err.println("receivedMessage By StompSessionHandler: 3");
                offer(destination, command);
            }else if(message != null){
                // System.err.println("receivedMessage By StompSessionHandler: 4");
                received(headers, text);
                answer(destination, message);
            }
        }
    }    

    /////////////////////////////////////////////////////////////////////
    //  @MessageMapping (Server Side)
    /////////////////////////////////////////////////////////////////////
    @MessageMapping("channel.{id}")
    public void handleMessage(@DestinationVariable(value = "id") String id, @Payload String text){

        WebSocketSession websocket = webSocketSessions.get(id);
        OCPPMessage<?> message = convertMessage(text);
        T command = convertCommand(text);

        if(message == null && command == null) {
            error(simpOperations, new RuntimeException("handleMessage", new IllegalArgumentException(String.format("'%s'", text))));
            return;
        }
        
        if(websocket != null) {
            if(command != null) {
                // System.err.println("receivedMessage By @MessageMapping : 1");
                offer(websocket, command);
            }else if(message != null){
                // System.err.println("receivedMessage By @MessageMapping : 2");
                received(simpOperations, text);
                answer(websocket, message);
            }
        }else{
            if(command != null) {
                // System.err.println("receivedMessage By @MessageMapping : 3"); //????
                offer("/topic/channel."+id, command);
            }else if(message != null){
                // System.err.println("receivedMessage By @MessageMapping : 4");
                received(simpOperations, text);
                answer("/topic/channel."+id, message);
            }
        }
    }


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
                error(session, new RuntimeException(session.getId(), t));
                return;
            }

            String send = null;
            try{
                OCPPMessage<?> m = removeSessionId(session, message);
                send = conversion.convertMessage(m);

                // System.err.println("sendMessage By WebSocketSession: ");
                session.sendMessage(new TextMessage(send));
            }catch(Exception e){
                // e.printStackTrace();
                error(session, new RuntimeException(session.getId(), t));
                return;
            }            
            send(session, send);
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

            boolean hasSession = this.stompSessions.size() > 0 ;
            StompSession session = hasSession
                ? this.stompSessions.values().stream().findFirst().get()
                : null;
            Object target = hasSession ? session : simpOperations;

            if(message == null && t != null) {
                error(target, new RuntimeException(destination, t));
                return;
            }

            String send = null;
            try{
                send = conversion.convertMessage(message);
                if(hasSession) {
                    // System.err.println("sendMessage By StompSession: "+destination);
                    session.send(destination, send);
                }else{
                    // System.err.println("sendMessage By SendingOperations: "+destination);
                    simpOperations.convertAndSend(destination, send);
                }
            }catch(Exception e){
                // e.printStackTrace();
                error(target, new RuntimeException(destination, t));
                return;
            }

            send(target, send);
        };
    }

    /////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////
    protected abstract T convertCommand(String payload);

    protected OCPPMessage<?> convertMessage(String payload){
        try{
            return conversion.convertMessage(payload);
        }catch(Exception e){
            return null;
        }        
    }

    protected String convertDestination(StompHeaders headers){

        String destination = headers.getDestination();
        try{
            int i1 = destination.lastIndexOf("channel.");
            int i2 = destination.length();
            return destination.substring(i1+8, i2);
        }catch(Exception e){
            return "";
        }
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
    protected void connect(Object source){
        brodcast("CONNECT", source, "{}");
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionConnectEvent(source));
    }
    protected void disconnect(Object source){
        brodcast("DISCONNECT", source, "{}");
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionDisconnectEvent(source));
    }
    protected void error(Object source, Throwable exception){
        brodcast("ERROR", source, exception);
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionErrorEvent(source, exception));
    }
    protected void received(Object source, String text){
        brodcast("RECEIVED", source, text);
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionReceivedEvent(source, text));        
    }
    protected void send(Object source, String text){
        brodcast("SEND", source, text);
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionSendEvent(source, text));
    }

    /////////////////////////////////////////////////////////////////////
    //
    /////////////////////////////////////////////////////////////////////
    private void brodcast(String action, Object source, Object payload){

        if(simpOperations == null || StringUtils.hasText(destination)) {
            Object message = createPayload(destination, action, source, payload);
            logger.info(String.format("[%s] %s", destination, message));
            // String d = StringUtils.hasText(description) ? "["+description+"]" : "";
            // if(ClassUtils.isAssignableValue(Throwable.class, payload)) {
            //     logger.info(d+""+action+": "+payload+" by "+source, (Throwable)payload);
            // }else{
            //     logger.info(d+""+action+": "+payload+" by "+source);
            // }
            return;
        }

        Object message = createPayload("/topic/console", action, source, payload);
        simpOperations.convertAndSend("/topic/console", message);
    }

    private String createPayload(String target, String action, Object source, Object payload){

        try{
            ObjectNode root = mapper.createObjectNode();
            root.put("target", target);
            root.put("action", action);


            ObjectNode src = mapper.createObjectNode();
            if(ObjectUtils.isEmpty(source)) {
                src.put("type", "Unknown");

            }else if(ClassUtils.isAssignableValue(WebSocketSession.class, source)) {
                WebSocketSession ws = (WebSocketSession)source;
                src.put("type", "WebSocketSession");
                src.put("id", ws.getId());
                src.put("localAddress", ws.getLocalAddress().toString());
                src.put("remoteAddress", ws.getRemoteAddress().toString());
                src.put("uri", ws.getUri().toString());
                src.put("acceptedProtocol", ws.getAcceptedProtocol().toString());
            }else if(ClassUtils.isAssignableValue(StompSession.class, source)) {
                src.put("type", "StompSession");

            }else if(ClassUtils.isAssignableValue(StompHeaders.class, source)) {
                src.put("type", "StompHeaders");

            }else if(ClassUtils.isAssignableValue(SimpMessageSendingOperations.class, source)) {
                src.put("type", "SimpMessageSendingOperations");

            }else{
                src.put("type", ClassUtils.getShortName(source.getClass()));
            }
            root.set("source", src);

            if(ClassUtils.isAssignableValue(Throwable.class, payload)) {
                Throwable t = (Throwable)payload;
                ArrayNode stack = mapper.createArrayNode();
                while(t != null) {
                    stack.add(t.toString());
                    t = t.getCause();
                }
                ObjectNode message = mapper.createObjectNode();
                message.set("exception", stack);
                root.set("message", message);


            }else if(ClassUtils.isAssignableValue(String.class, payload)) {
                String t = (String)payload;
                JsonNode message = mapper.readTree(t);
                root.set("message", message);
            }else{
                JsonNode message = mapper.convertValue(payload, JsonNode.class);
                root.set("message", message);
            }
            // return root;
            return mapper.writeValueAsString(root);
        }catch(Exception e) {
            // e.printStackTrace();
            return "{}";
        }
    }

}