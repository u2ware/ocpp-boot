package io.u2ware.ocpp.core;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.socket.WebSocketSession;

public class OCPPSessionErrorEvent extends ApplicationEvent{

    private String text;
    private Throwable t;

    public OCPPSessionErrorEvent(WebSocketSession source, String text, Throwable t) {
        super(source);
        this.text = text;
        this.t = t;
    }

    public WebSocketSession getWebSocketSession(){
        return (WebSocketSession)getSource();
    }   
    
    public String getPayload(){
        return text;
    }         

    public Throwable getException(){
        return t;
    }
}