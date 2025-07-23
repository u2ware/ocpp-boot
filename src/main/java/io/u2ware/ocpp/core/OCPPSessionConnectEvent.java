package io.u2ware.ocpp.core;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.socket.WebSocketSession;

public class OCPPSessionConnectEvent extends ApplicationEvent{

    public OCPPSessionConnectEvent(WebSocketSession source) {
        super(source);
    }

    public WebSocketSession getWebSocketSession(){
        return (WebSocketSession)getSource();
    }    
}