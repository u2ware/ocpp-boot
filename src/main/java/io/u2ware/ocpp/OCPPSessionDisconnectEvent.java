package io.u2ware.ocpp;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.socket.WebSocketSession;

public class OCPPSessionDisconnectEvent extends ApplicationEvent{

    public OCPPSessionDisconnectEvent(Object source) {
        super(source);
    }

}