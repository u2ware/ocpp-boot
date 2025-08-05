package io.u2ware.ocpp;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.socket.WebSocketSession;

public class OCPPSessionConnectEvent extends ApplicationEvent{

    public OCPPSessionConnectEvent(Object source) {
        super(source);
    }

}