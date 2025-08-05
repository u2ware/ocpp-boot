package io.u2ware.ocpp;

import org.springframework.context.ApplicationEvent;

public class OCPPSessionReceivedEvent extends ApplicationEvent{

    private String payload;

    public OCPPSessionReceivedEvent(Object source, String payload) {
        super(source);
        this.payload = payload;
    }
    
    public String getPayload(){
        return payload;
    }         
}