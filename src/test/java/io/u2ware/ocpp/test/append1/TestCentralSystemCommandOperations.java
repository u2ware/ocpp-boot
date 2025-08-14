package io.u2ware.ocpp.test.append1;

import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandOperations;

public class TestCentralSystemCommandOperations extends AbstractEventBusTemplate<CentralSystemCommand> implements CentralSystemCommandOperations{

    public TestCentralSystemCommandOperations(ApplicationContext ac){
        super(new CentralSystem().registerDefaultHandlers(), ac);
    }

    public TestCentralSystemCommandOperations(CentralSystem operations, ApplicationContext ac){
        super(operations, ac);
    }

    @Override
    public void send(String destination, CentralSystemCommand payload) {
        operations.offer(payload, new ServerEventPublisher());
    }

    public void send(CentralSystemCommand payload) {
        operations.offer(payload, new ServerEventPublisher());
    }

}