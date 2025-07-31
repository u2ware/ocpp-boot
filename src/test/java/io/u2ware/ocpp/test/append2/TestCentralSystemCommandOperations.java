package io.u2ware.ocpp.test.append2;

import org.springframework.messaging.simp.stomp.StompSession;

import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandOperations;

public class TestCentralSystemCommandOperations extends AbstractWebsocketStompTemplate<CentralSystem> implements CentralSystemCommandOperations{

    public TestCentralSystemCommandOperations(CentralSystem operations, String destination){
        super(operations, destination);
    }

    @Override
    public void send(CentralSystemCommand payload) {
        connections.keySet().stream().findFirst().ifPresentOrElse((id) -> {
            send(id, payload);
        }, ()->{
            brodcast(null, "ERROR70", new NullPointerException("session"));
        });
    }

    @Override
    public void send(String destination, CentralSystemCommand payload) {

        StompSession session = connections.get(destination);
        if(session == null) {
            brodcast(null, "ERROR71", new NullPointerException(destination));
            return;
        }
        operations.offer(payload, (m,e)->{ send(session, m, e);});
    }
}
