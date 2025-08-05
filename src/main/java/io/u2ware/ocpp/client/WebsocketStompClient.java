package io.u2ware.ocpp.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.converter.AbstractMessageConverter;
import org.springframework.messaging.converter.CompositeMessageConverter;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSession.Subscription;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestOperations;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import com.fasterxml.jackson.databind.JsonNode;


public class WebsocketStompClient {
    

    protected Log logger = LogFactory.getLog(getClass());


    private WebSocketStompClient client;
    private StompSession session;
    private Map<String,Subscription> subscriptions = new HashMap<>();
    private StompFrameHandler handler;


    public static WebsocketStompClient with() {
        WebSocketClient client = new StandardWebSocketClient();
        return new WebsocketStompClient(client);
    }
    public static WebsocketStompClient withSockJS() {
        return withSockJS(new RestTemplateXhrTransport());
    }
    public static WebsocketStompClient withSockJS(RestOperations restOperations) {
        return withSockJS(new RestTemplateXhrTransport(restOperations));
    }
    private static WebsocketStompClient withSockJS(RestTemplateXhrTransport transport) {
        List<Transport> transports = new ArrayList<>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        transports.add(transport);
        SockJsClient client = new SockJsClient(transports);
        return new WebsocketStompClient(client);
    }

    private WebsocketStompClient(WebSocketClient manager){

        MappingJackson2MessageConverter jsonConverter = new MappingJackson2MessageConverter();
        StringMessageConverter textConverter = new StringMessageConverter();
        JsonNodeConverter jj = new JsonNodeConverter();
        CompositeMessageConverter messageConverter = new CompositeMessageConverter(Arrays.asList(jsonConverter, textConverter, jj));

        WebSocketStompClient client = new WebSocketStompClient(manager);
        client.setMessageConverter(messageConverter);
        this.client = client;
    }



    public static class JsonNodeConverter extends AbstractMessageConverter {

        @Override
        protected boolean supports(Class<?> clazz) {
            return (JsonNode.class == clazz);
        }
        
    }




	public boolean isConnected() {
		return (this.session != null && this.session.isConnected());
	}

    public WebsocketStompClient sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return this;
    }

    public CompletableFuture<WebsocketStompClient> connect(String uri, StompSessionHandler handler){
        if(session != null) {
            return CompletableFuture.completedFuture(WebsocketStompClient.this);
        }

        return this.client.connectAsync(uri, handler)
            .thenApply((session)->{
                this.handler = handler;
                this.session = session;
                return WebsocketStompClient.this;
            });
    }

    public CompletableFuture<WebsocketStompClient> connect(String uri){
        return connect(uri, new WebsocketStompLoggingHandler());
    }

    public CompletableFuture<WebsocketStompClient> disconnect(){

        if(session == null) {
            return CompletableFuture.completedFuture(this);
        }
        return CompletableFuture.supplyAsync(()->{
            try{
                synchronized(session) {
                    session.disconnect();
                    session = null;
                }
                return WebsocketStompClient.this;
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });
    }

    public <T> CompletableFuture<WebsocketStompClient> broadcast(String destination, T payload) {

        if(session == null) {
            return CompletableFuture.failedFuture(new NullPointerException());
        }

        System.err.println("broadcast");
        System.err.println("broadcast: "+destination);
        System.err.println("broadcast: "+payload);

        return CompletableFuture.supplyAsync(()->{
            try{
                synchronized(session) {
                    session.send(destination, payload);
                }
                return WebsocketStompClient.this;
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });
    }


    public CompletableFuture<WebsocketStompClient> subscribe(String destination){
        if(this.handler == null) {
            return CompletableFuture.failedFuture(new NullPointerException());
        }        
        return subscribe(destination, this.handler);
    }    


    public CompletableFuture<WebsocketStompClient> subscribe(String destination, StompFrameHandler handler){

        if(session == null || ! StringUtils.hasText(destination)) {
            return CompletableFuture.failedFuture(new NullPointerException());
        }
        return CompletableFuture.supplyAsync(()->{
            try{
                synchronized(session) {
                    Subscription s = session.subscribe(destination, handler);
                    this.subscriptions.put(destination, s);
                }
                return WebsocketStompClient.this;
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });
    }    

    public CompletableFuture<WebsocketStompClient> unsubscribe(String destination){
        if(session == null || ! StringUtils.hasText(destination)) {
            return CompletableFuture.failedFuture(new NullPointerException());
        }
        return CompletableFuture.supplyAsync(()->{
            try{
                synchronized(session) {
                    this.subscriptions.remove(destination).unsubscribe();
                }
                return WebsocketStompClient.this;
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        });
    }
}
