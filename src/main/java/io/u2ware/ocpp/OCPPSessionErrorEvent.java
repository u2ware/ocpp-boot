package io.u2ware.ocpp;

import org.springframework.context.ApplicationEvent;

public class OCPPSessionErrorEvent extends ApplicationEvent{

    private Throwable t;

    public OCPPSessionErrorEvent(Object source, Throwable t) {
        super(source);
        this.t = t;
    }

    public Throwable getPayload(){
        return t;
    }
}