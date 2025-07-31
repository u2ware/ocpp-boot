package io.u2ware.ocpp.test.append2;

import org.springframework.messaging.simp.stomp.StompSession;

import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandOperations;

public class TestChargePointCommandOperations extends AbstractWebsocketStompTemplate<ChargePoint> implements ChargePointCommandOperations{

    public TestChargePointCommandOperations(ChargePoint operations, String destination){
        super(operations, destination);
    }

    @Override
    public void send(ChargePointCommand payload) {
        connections.keySet().stream().findFirst().ifPresentOrElse((id) -> {
            send(id, payload);
        }, ()->{
            brodcast(null, "ERROR70", new NullPointerException("session"));
        });
    }

    @Override
    public void send(String destination, ChargePointCommand payload) {

        StompSession session = connections.get(destination);
        if(session == null) {
            brodcast(null, "ERROR71", new NullPointerException(destination));
            return;
        }
        operations.offer(payload, (m,e)->{ send(session, m, e);});
    }
}