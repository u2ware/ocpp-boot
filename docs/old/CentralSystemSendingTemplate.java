package io.u2ware.ocpp.v1_6.messaging;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.WebSocketSession;

import io.u2ware.ocpp.core.OCPPReflection;
import io.u2ware.ocpp.core.OCPPSessionTemplate;

public class CentralSystemSendingTemplate extends OCPPSessionTemplate<CentralSystem> implements CentralSystemSendingOperations {

    public CentralSystemSendingTemplate(CentralSystem operations) {
        super(operations, null);
    }

    public CentralSystemSendingTemplate(CentralSystem operations, SimpMessageSendingOperations simpOperations) {
        super(operations, simpOperations);
    }

    @Override
    public void convertAndSend(CentralSystemFeature feature) {
        connections.keySet().stream().findFirst().ifPresentOrElse((id) -> {
            convertAndSend(id, feature);
        }, ()->{
            brodcast(null, "ERROR90", new NullPointerException("session"));
        });
    }

    @Override
    public void convertAndSend(String destination, CentralSystemFeature feature) {

        String key = OCPPReflection.extractElement(connections.keySet(), destination);
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