package io.u2ware.ocpp.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;


public class WebsocketStandardClient {

    protected Log logger = LogFactory.getLog(getClass());

    private WebSocketClient client;
    private WebSocketSession session;


    public static WebsocketStandardClient with() {
        WebSocketClient client = new StandardWebSocketClient();
        return new WebsocketStandardClient(client);
    }
    public static WebsocketStandardClient withSockJS() {
        return withSockJS(new RestTemplateXhrTransport());
    }
    public static WebsocketStandardClient withSockJS(RestOperations restOperations) {
        return withSockJS(new RestTemplateXhrTransport(restOperations));
    }
    private static WebsocketStandardClient withSockJS(RestTemplateXhrTransport transport) {
        List<Transport> transports = new ArrayList<>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        transports.add(transport);
        SockJsClient client = new SockJsClient(transports);
        return new WebsocketStandardClient(client);
    }


    private WebsocketStandardClient(WebSocketClient client){
        this.client = client;
    }


    //////////////////////////////////////////////
    //
    //////////////////////////////////////////////
	public boolean isConnected() {
		return (this.session != null && this.session.isOpen());
	}
	public String getId() {
		return (this.session != null) ? this.session.getId() : null;
	}

    public WebsocketStandardClient sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return this;
    }


    public CompletableFuture<WebsocketStandardClient> connect(String uri, WebSocketHandler handler){
        if(isConnected()) {
            return CompletableFuture.completedFuture(WebsocketStandardClient.this);
        }

        return this.client.execute(handler, uri).thenApply((session->{
            this.session = session;
            return WebsocketStandardClient.this;
        }));
    }

	public CompletableFuture<WebsocketStandardClient> disconnect()  {

        if(! isConnected()) {
            return CompletableFuture.completedFuture(this);
        }
        return CompletableFuture.supplyAsync(()->{
            try{
                synchronized(session) {
                    session.close();
                    session = null;
                }
                return WebsocketStandardClient.this;
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });
	}

    public <T> CompletableFuture<WebsocketStandardClient> send(WebSocketMessage<T> message)  {
        if(session == null) {
            return CompletableFuture.completedFuture(this);
        }
        return CompletableFuture.supplyAsync(()->{
            try{
                synchronized(session) {
                    session.sendMessage(message);
                }
                return WebsocketStandardClient.this;
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });
    }



}