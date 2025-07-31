package io.u2ware.ocpp.v1_6.messaging;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.WebSocketSession;

import io.u2ware.ocpp.OCPPFeature;
import io.u2ware.ocpp.OCPPSessionHandlerTemplate;

public class CentralSystemCommandTemplate extends OCPPSessionHandlerTemplate<CentralSystem> implements CentralSystemCommandOperations {

    public CentralSystemCommandTemplate(CentralSystem operations) {
        super(operations, null);
    }

    public CentralSystemCommandTemplate(CentralSystem operations, SimpMessageSendingOperations simpOperations) {
        super(operations, simpOperations);
    }

    @Override
    public void send(CentralSystemCommand feature) {
        connections.keySet().stream().findFirst().ifPresentOrElse((id) -> {
            send(id, feature);
        }, ()->{
            brodcast(null, "ERROR90", new NullPointerException("session"));
        });
    }

    @Override
    public void send(String destination, CentralSystemCommand feature) {

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