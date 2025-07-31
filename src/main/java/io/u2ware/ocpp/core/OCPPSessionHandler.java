package io.u2ware.ocpp.core;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public abstract class OCPPSessionHandler<T extends OCPPFeatureOperations> extends TextWebSocketHandler{


    protected OCPPConversion conversion = new OCPPConversion();
    protected T operations;
    protected Map<String, WebSocketSession> connections = new HashMap<>();


    protected OCPPSessionHandler(T operations) {
        Assert.notNull(operations, "operations");
        this.operations = operations;
    }

    /////////////////////////////////////////////////////////////////////
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {       
        this.connections.put(session.getId(), session);
        connect(session);
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        this.connections.remove(session.getId());
        disconnect(session);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        error(session, "ERROR", exception);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage text) throws Exception {
        String received = text.getPayload();
        OCPPMessage<?> message = null;
        try{
            message = convert(session, received);
        }catch(Exception e){
            error(session, "ERROR01",  e);
            return;
        }
        received(session, received);
        operations.answer(message, handleTextMessage(session));
    }

    /////////////////////////////////////////////////////////////////////
    protected OCPPConsumer<OCPPMessage<?>> handleTextMessage(WebSocketSession session){
        return (m,t)->{
            if(m == null && t == null) {
                return;
            }
            if(m == null && t != null) {
                error(session, "ERROR02",  t);
                return;
            }
            String send = null;
            try{
                send = convert(session, m);
                session.sendMessage(new TextMessage(send));
            }catch(Exception e) {
                error(session, "ERROR03", e);
                return;
            }
            send(session, send);
        };
    }


    /////////////////////////////////////////////////////////////////////
    private OCPPMessage<?> convert(WebSocketSession session, String text) throws Exception{
        OCPPMessage<?> message = conversion.convertMessage(text);
        if(message == null) throw new NullPointerException("message");

        if(! message.getId().contains(session.getId())) {
            message.setId(message.getId()+session.getId());
        }
        
        return message;
    }

    private String convert(WebSocketSession session, OCPPMessage<?> message) throws Exception{

        if(message == null) throw new NullPointerException("message");

        if(message.getId().contains(session.getId())) {
            message.setId(message.getId().replace(session.getId(), ""));
        }
        return conversion.convertMessage(message);
    }  

    /////////////////////////////////////////////////////////////////////
    protected void connect(WebSocketSession session){
        // logger.info("connect: ");
    }
    protected void disconnect(WebSocketSession session){
        // logger.info("disconnect: ");
    }
    protected void received(WebSocketSession session, String text){
        // logger.info("disconnect: ");
    }
    protected void send(WebSocketSession session, String text){
        // logger.info("disconnect: ");
    }
    protected void error(WebSocketSession session, String text, Throwable exception){
        // logger.info("disconnect: ");
    }



}