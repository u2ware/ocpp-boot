package io.u2ware.ocpp;

import org.springframework.context.ApplicationEvent;

public class OCPPSessionConnectEvent extends ApplicationEvent{

    public OCPPSessionConnectEvent(Object source) {
        super(source);
    }

}