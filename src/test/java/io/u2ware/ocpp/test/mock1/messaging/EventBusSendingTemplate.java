package io.u2ware.ocpp.test.mock1.messaging;

import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.v1_6.messaging.SpecificationOperations;
import io.u2ware.ocpp.v1_6.messaging.SpecificationAction;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;

public class EventBusSendingTemplate extends AbstractEventBusTemplate<SpecificationOperations> implements SpecificationSendingOperations{

    public EventBusSendingTemplate(SpecificationOperations operations, ApplicationContext ac){
        super(operations, ac);
    }

    @Override
    public void convertAndSend(String destination, SpecificationAction payload) {
        convertAndSend(payload);
    }

    @Override
    public void convertAndSend(SpecificationAction payload) {
        if(operations.isServer()) {
            operations.offer(payload, new ServerEventPublisher());
        }else{
            operations.offer(payload, new ClientEventPublisher());
        }
    }


}