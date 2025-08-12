package io.u2ware.ocpp.client;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;


public class WebsocketStandardConnectionManager extends WebSocketHandlerDecorator {

    private WebSocketSession session;
    private WebSocketClient client;
    private String uri ;

    public WebsocketStandardConnectionManager(WebSocketClient client, WebSocketHandler delegate, String uri) {
        super(delegate);
        this.client = client;
        this.uri = uri;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        this.session = session;
        super.afterConnectionEstablished(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        this.session = null;
        super.afterConnectionClosed(session, closeStatus);
    }

    ////////////////////////////////////////////////
    //
    ////////////////////////////////////////////////
    public boolean isOpen() {
        return (this.session != null && this.session.isOpen());
    }

    public void close() throws Exception{
        if(session == null) throw new RuntimeException("session is not found");
        session.close();
        session = null;
    }

    public CompletableFuture<WebSocketSession> open() throws Exception{
        try{
            return client.execute(this, uri);
        }catch(Throwable e){
            e.printStackTrace();
            return CompletableFuture.failedFuture(e);
        }
    }

    public <T> void sendMessage(WebSocketMessage<T> message) throws Exception{
        if(session == null) throw new RuntimeException("session is not found");
        session.sendMessage(message); 
    }
}