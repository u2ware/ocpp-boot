package io.u2ware.ocpp.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public abstract class OCPPWebsocketHandler<T extends OCPPOperations> extends TextWebSocketHandler{

	protected Log logger = LogFactory.getLog(getClass());

    protected OCPPConversion conversion = new OCPPConversion();
    protected T operations;
    protected Map<String, WebSocketSession> connections = new HashMap<>();


    protected OCPPWebsocketHandler(T operations) {
        Assert.notNull(operations, "operations");
        this.operations = operations;
    }


    /////////////////////////////////////////////////////////////////////
    protected void received(WebSocketSession session, String payload) {
        OCPPMessage<?> message = null;
        try{
            message = read(session, payload);
        }catch(Exception e){
            brodcast(session, "ERROR01", e);
            return;            
        }
        operations.answer(message, (m,e)->{ send(session, m, e);});
    }

    protected void send(WebSocketSession session, OCPPMessage<?> m, Throwable u) {
        if(m == null) {
            brodcast(session, "ERROR02", u);
            return;
        }
        try{
            String text = write(session, m);
            brodcast(session, "SEND", text);            
        }catch(Exception e) {
            brodcast(session, "ERROR03", e);
        }
    }

    /////////////////////////////////////////////////////////////////////
    protected OCPPMessage<?> read(WebSocketSession session, String text) throws Exception{
        OCPPMessage<?> message = conversion.convertMessage(text);
        if(message == null) throw new NullPointerException("message");

        if(! message.getId().contains(session.getId())) {
            message.setId(message.getId()+session.getId());
        }
        
        return message;
    }

    protected String write(WebSocketSession session, OCPPMessage<?> message) throws Exception{

        if(message == null) throw new NullPointerException("message");

        if(message.getId().contains(session.getId())) {
            message.setId(message.getId().replace(session.getId(), ""));
        }

        String text = conversion.convertMessage(message);
        session.sendMessage(new TextMessage(text));
        return text;
    }



    /////////////////////////////////////////////////////////////////////
    protected void brodcast(WebSocketSession session, String action, Object resource){
        if(ClassUtils.isAssignableValue(Throwable.class, resource)) {
            logger.info(action+": ", (Throwable)resource);
        }else{
            logger.info(action+": "+resource);
        }
    }
    protected void connect(WebSocketSession session){
        // logger.info("connect: ");
    }
    protected void disconnect(WebSocketSession session){
        // logger.info("disconnect: ");
    }


    /////////////////////////////////////////////////////////////////////
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {       
        this.connections.put(session.getId(), session);
        brodcast(session, "CONNECTED", null);
        connect(session);
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        this.connections.remove(session.getId());
        brodcast(session,  "DISCONNECTED", null);
        disconnect(session);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        brodcast(session, "ERROR00", exception);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage payload) throws Exception {
        brodcast(session, "RECEIVED", payload.getPayload());
        received(session, payload.getPayload());
    }
}