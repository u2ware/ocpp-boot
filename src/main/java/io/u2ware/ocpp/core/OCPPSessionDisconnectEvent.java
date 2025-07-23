package io.u2ware.ocpp.core;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.socket.WebSocketSession;

public class OCPPSessionDisconnectEvent extends ApplicationEvent{

    public OCPPSessionDisconnectEvent(WebSocketSession source) {
        super(source);
    }

    public WebSocketSession getWebSocketSession(){
        return (WebSocketSession)getSource();
    }    
}