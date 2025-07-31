package io.u2ware.ocpp.v2_0_1.messaging;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.WebSocketSession;

import io.u2ware.ocpp.core.OCPPFeature;
import io.u2ware.ocpp.core.OCPPSessionHandlerTemplate;

public class CSMSCommandTemplate extends OCPPSessionHandlerTemplate<CSMS> implements CSMSCommandOperations {

    public CSMSCommandTemplate(CSMS operations) {
        super(operations, null);
    }

    public CSMSCommandTemplate(CSMS operations, SimpMessageSendingOperations simpOperations) {
        super(operations, simpOperations);
    }

    @Override
    public void send(CSMSCommand feature) {
        connections.keySet().stream().findFirst().ifPresentOrElse((id) -> {
            send(id, feature);
        }, ()->{
            brodcast(null, "ERROR90", new NullPointerException("session"));
        });
    }

    @Override
    public void send(String destination, CSMSCommand feature) {

        String key = OCPPFeature.extractElement(connections.keySet(), destination);
        WebSocketSession session = connections.get(key);
        if(session == null) {
            brodcast(null, "ERROR91", new NullPointerException(destination));
            return;
        }

        if(! feature.getIdentifier().contains(session.getId())) {
            feature.setIdentifier(feature.getIdentifier()+""+session.getId());
        }
        operations.offer(feature, super.handleTextMessage(session));
    }

}