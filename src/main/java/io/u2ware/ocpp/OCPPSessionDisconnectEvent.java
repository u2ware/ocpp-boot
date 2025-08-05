package io.u2ware.ocpp;

import org.springframework.context.ApplicationEvent;

public class OCPPSessionDisconnectEvent extends ApplicationEvent{

    public OCPPSessionDisconnectEvent(Object source) {
        super(source);
    }

}