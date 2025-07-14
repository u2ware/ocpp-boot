package io.u2ware.ocpp.test.mock2.messaging;

import org.springframework.messaging.simp.stomp.StompSession;

import io.u2ware.ocpp.v1_6.messaging.SpecificationAction;
import io.u2ware.ocpp.v1_6.messaging.SpecificationOperations;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;

public class WebsocketStompSendingTemplate extends AbstractWebsocketStompTemplate<SpecificationOperations> implements SpecificationSendingOperations{

    
    public WebsocketStompSendingTemplate(SpecificationOperations operations, String destination) {
        super(operations, destination);
    }

    @Override
    public void convertAndSend(SpecificationAction payload) {
        connections.keySet().stream().findFirst().ifPresentOrElse((id) -> {
            convertAndSend(id, payload);
        }, ()->{
            brodcast(null, "ERROR70", new NullPointerException("session"));
        });
    }

    @Override
    public void convertAndSend(String destination, SpecificationAction payload) {

        StompSession session = connections.get(destination);
        if(session == null) {
            brodcast(null, "ERROR71", new NullPointerException(destination));
            return;
        }
        operations.offer(payload, (m,e)->{ send(session, m, e);});
    }    
}
