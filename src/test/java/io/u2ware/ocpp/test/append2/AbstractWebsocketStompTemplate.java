package io.u2ware.ocpp.test.append2;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import io.u2ware.ocpp.core.OCPPConversion;
import io.u2ware.ocpp.core.OCPPMessage;
import io.u2ware.ocpp.core.OCPPFeatureOperations;

public class AbstractWebsocketStompTemplate<T extends OCPPFeatureOperations> implements StompSessionHandler {
    

	protected Log logger = LogFactory.getLog(getClass());

    protected OCPPConversion conversion = new OCPPConversion();
    protected T operations;
    protected Map<String, StompSession> connections = new HashMap<>();

    protected String broadcasting;
    protected String subscriptions;



    protected AbstractWebsocketStompTemplate(T operations, String destination) {
        Assert.notNull(operations, "actor");
        this.operations = operations;
        this.broadcasting = destination + (operations.isServer() ? "Client" : "Server");
        this.subscriptions = destination+(operations.isServer() ? "Server" : "Client");
    }

    /////////////////////////////////////////////////////////////////////
    protected OCPPMessage<?> read(StompSession session, String text) throws Exception{
        OCPPMessage<?> message = conversion.convertMessage(text);
        if(message == null) throw new NullPointerException("message");

        return message;
    }

    protected String write(StompSession session, OCPPMessage<?> message) throws Exception{

        if(message == null) throw new NullPointerException("message");

        String text = conversion.convertMessage(message);
        session.send(broadcasting, text);
        return text;
    }


    protected void received(StompSession session, String payload) {
        OCPPMessage<?> message = null;
        try{
            message = read(session, payload);
        }catch(Exception e){
            brodcast(session, "ERROR01", e);
            return;            
        }
        operations.answer(message, (m,e)->{ send(session, m, e);});
    }

    protected void send(StompSession session, OCPPMessage<?> m, Throwable u) {
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

    protected void brodcast(StompSession session, String action, Object resource){
        if(ClassUtils.isAssignableValue(Throwable.class, resource)) {
            logger.info(action+": ", (Throwable)resource);
        }else{
            logger.info(action+": "+resource);
        }
    }
    protected void connect(StompSession session){
        // logger.info("connect: ");
    }
    protected void disconnect(StompSession session){
        // logger.info("disconnect: ");
    }


    /////////////////////////////////////////////////////////////////////
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        this.connections.put(session.getSessionId(), session);
        brodcast(session, "CONNECTED", null);
        connect(session);

        session.subscribe(subscriptions, new StompFrameHandler(){
            public Type getPayloadType(StompHeaders headers) {
                return String.class;
            }
            public void handleFrame(StompHeaders headers, Object payload) {
                handleTextMessage(session, headers, (String)payload);
            }
        });
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        this.connections.remove(session.getSessionId());
        brodcast(session,  "DISCONNECTED", null);
        disconnect(session);
    }


    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        brodcast(session, "ERROR00", exception);
    } 

    protected void handleTextMessage(StompSession session, StompHeaders headers, String payload)  {
        brodcast(session, "RECEIVED", payload);
        received(session, payload);
    } 



    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }
    @Override
    public void handleFrame(StompHeaders headers, Object payload) {

    }
}
