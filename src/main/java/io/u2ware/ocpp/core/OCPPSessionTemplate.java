package io.u2ware.ocpp.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.util.ClassUtils;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class OCPPSessionTemplate<T extends OCPPOperations> extends OCPPSessionHandler<T> implements ApplicationContextAware{
    
    protected SimpMessageSendingOperations simpOperations; 
    protected ApplicationContext applicationContext;
    protected ObjectMapper mapper = new ObjectMapper();

    protected OCPPSessionTemplate(T operation, SimpMessageSendingOperations simpOperations) {
        super(operation);
        this.simpOperations = simpOperations;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    
    @Override
    protected void connect(WebSocketSession session){
        brodcast(session, "CONNECT", "{}");
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionConnectEvent(session));

    }

    @Override
    protected void disconnect(WebSocketSession session){
        brodcast(session, "DISCONNECT", "{}");
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionDisconnectEvent(session));
    }

    protected void received(WebSocketSession session, String text){
        brodcast(session, "RECEIVED", text);
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionSendEvent(session, text));
    }
    protected void send(WebSocketSession session, String text){
        brodcast(session, "SEND", text);
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionReceivedEvent(session, text));
    }
    protected void error(WebSocketSession session, String text, Throwable exception){
        brodcast(session, text, exception);
        if(applicationContext == null) return;
        applicationContext.publishEvent(new OCPPSessionErrorEvent(session, text, exception));
    }


    protected void brodcast(WebSocketSession session, String action, Object resource){

        if(simpOperations == null) return;
        String destination = "/topic/console";
        String payload = createPayload(session, action, resource);
        simpOperations.convertAndSend(destination, payload);
    }


    //////////////
    private String createPayload(WebSocketSession session, String action, Object resource){

        try{
            ObjectNode root = mapper.createObjectNode();

            if(session != null) {
                ObjectNode target = mapper.createObjectNode();
                target.put("id", session.getId());
                target.put("localAddress", session.getLocalAddress().toString());
                target.put("remoteAddress", session.getRemoteAddress().toString());
                target.put("uri", session.getUri().toString());
                target.put("acceptedProtocol", session.getAcceptedProtocol().toString());

                root.set("target", target);
            }else{
                root.set("target", null);
            }

            root.put("action", action);

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


            return mapper.writeValueAsString(root);
        }catch(Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

}
