package io.u2ware.ocpp;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.socket.WebSocketSession;


public class OCPPSessionReceivedEvent extends ApplicationEvent{

    private String payload;

    public OCPPSessionReceivedEvent(WebSocketSession source, String payload) {
        super(source);
        this.payload = payload;
    }

    public WebSocketSession getWebSocketSession(){
        return (WebSocketSession)getSource();
    }   
    
    public String getPayload(){
        return payload;
    }         
}