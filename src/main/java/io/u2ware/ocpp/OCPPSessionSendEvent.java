package io.u2ware.ocpp;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.socket.WebSocketSession;

public class OCPPSessionSendEvent extends ApplicationEvent{

    private String payload;

    public OCPPSessionSendEvent(Object source, String payload) {
        super(source);
        this.payload = payload;
    }

    public String getPayload(){
        return payload;
    }         
}