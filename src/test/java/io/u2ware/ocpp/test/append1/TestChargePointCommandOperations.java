package io.u2ware.ocpp.test.append1;

import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandOperations;

public class TestChargePointCommandOperations extends AbstractEventBusTemplate<ChargePoint> implements ChargePointCommandOperations{

    public TestChargePointCommandOperations(ApplicationContext ac){
        super(new ChargePoint().registerDefaultFeatures(), ac);
    }

    public TestChargePointCommandOperations(ChargePoint operations, ApplicationContext ac){
        super(operations, ac);
    }

    @Override
    public void send(String destination, ChargePointCommand payload) {
        send(payload);
    }

    @Override
    public void send(ChargePointCommand payload) {
        operations.offer(payload, new ClientEventPublisher());
    }
}