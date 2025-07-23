package io.u2ware.ocpp.v1_6.messaging;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.WebSocketSession;

import io.u2ware.ocpp.core.OCPPReflection;
import io.u2ware.ocpp.core.OCPPSessionTemplate;

public class SpecificationSendingTemplate extends OCPPSessionTemplate<SpecificationOperations> implements SpecificationSendingOperations {

    public SpecificationSendingTemplate(SpecificationOperations operations) {
        super(operations, null);
    }

    public SpecificationSendingTemplate(SpecificationOperations operations, SimpMessageSendingOperations simpOperations) {
        super(operations, simpOperations);
    }

    @Override
    public void convertAndSend(SpecificationAction payload) {
        connections.keySet().stream().findFirst().ifPresentOrElse((id) -> {
            convertAndSend(id, payload);
        }, ()->{
            brodcast(null, "ERROR90", new NullPointerException("session"));
        });
    }

    @Override
    public void convertAndSend(String destination, SpecificationAction payload) {

        String key = OCPPReflection.extractElement(connections.keySet(), destination);
        WebSocketSession session = connections.get(key);
        if(session == null) {
            brodcast(null, "ERROR91", new NullPointerException(destination));
            return;
        }

        if(! payload.getIdentifier().contains(session.getId())) {
            payload.setIdentifier(payload.getIdentifier()+""+session.getId());
        }

        operations.offer(payload, super.handleTextMessage(session));
    }
}