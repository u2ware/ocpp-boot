package io.u2ware.ocpp.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ClassUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketExtension;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;
import org.springframework.web.util.UriComponentsBuilder;


public class MockWebSocketHandlerInvoker {
    

    public static MockWebSocketHandlerInvoker of(ApplicationContext ac) {
        return new MockWebSocketHandlerInvoker(ac);
    }
    
    private Map<WebSocketHandler, WebSocketHandler> delegate = new HashMap<>();
    private Map<WebSocketSession, WebSocketHandler> session = new HashMap<>();
    private MockWebSocketSessionWorker consumer = new MockWebSocketSessionWorker(session);

    private MockWebSocketHandlerInvoker(ApplicationContext ac){
        Map<String, WebSocketHandler> handlers = ac.getBeansOfType(WebSocketHandler.class);
        for(WebSocketHandler h : handlers.values()) {
            registerDecorator(h);
        }        
    }

    public void connect(WebSocketHandler... handlers){
        for(WebSocketHandler h : handlers) {
            registerDecorator(h);
            registerConnector(h);
        }
        startConnector();
    }


    private void registerDecorator(WebSocketHandler h){       
        if(ClassUtils.isAssignableValue(SubProtocolWebSocketHandler.class, h)) return;        
        if(ClassUtils.isAssignableValue(WebSocketHandlerDecorator.class, h)) {
            WebSocketHandlerDecorator d = (WebSocketHandlerDecorator)h;
            delegate.put(d.getDelegate(), h);
        }
    }

    private void registerConnector(WebSocketHandler h){

        if(ClassUtils.isAssignableValue(SubProtocolWebSocketHandler.class, h)) return;
        WebSocketHandler d = delegate.get(h);
        WebSocketSession s = new MockWebSocketSession(consumer);
        session.put(s, d != null ? d : h);
    }







    private void startConnector(){
        for(WebSocketSession s : session.keySet()) {
            WebSocketHandler handler = session.get(s);
            try {
                handler.afterConnectionEstablished(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }







    private static class MockWebSocketSessionWorker implements BiConsumer<WebSocketSession, WebSocketMessage<?>> {

        private Map<WebSocketSession, WebSocketHandler> handlers;

        private MockWebSocketSessionWorker(Map<WebSocketSession, WebSocketHandler> handlers){
            this.handlers = handlers;
        }

        @Override
        public void accept(WebSocketSession s, WebSocketMessage<?> u) {

            for(WebSocketSession session : handlers.keySet()) {

                if(session.getId().equals(s.getId())) continue;

                WebSocketHandler handler = handlers.get(session);
                try {
                    handler.handleMessage(session, u);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static class MockWebSocketSession implements WebSocketSession {

        private MockWebSocketSessionWorker consumer;
        private String id;

        private MockWebSocketSession(MockWebSocketSessionWorker consumer){
            this.consumer = consumer;
            this.id = UUID.randomUUID().toString();
        }


        @Override
        public String getId() {
            return id;
        }

        @Override
        public URI getUri() {
            return UriComponentsBuilder.fromPath("/test").build().toUri();
        }

        @Override
        public HttpHeaders getHandshakeHeaders() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getHandshakeHeaders'");
        }

        @Override
        public Map<String, Object> getAttributes() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getAttributes'");
        }

        @Override
        public Principal getPrincipal() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getPrincipal'");
        }

        @Override
        public InetSocketAddress getLocalAddress() {
            return new InetSocketAddress("localhost", 10);
        }

        @Override
        public InetSocketAddress getRemoteAddress() {
            return new InetSocketAddress("localhost",20);
        }

        @Override
        public String getAcceptedProtocol() {
            return "v12.stomp";
        }

        @Override
        public void setTextMessageSizeLimit(int messageSizeLimit) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setTextMessageSizeLimit'");
        }

        @Override
        public int getTextMessageSizeLimit() {
            return Integer.MAX_VALUE;
        }

        @Override
        public void setBinaryMessageSizeLimit(int messageSizeLimit) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'setBinaryMessageSizeLimit'");
        }

        @Override
        public int getBinaryMessageSizeLimit() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getBinaryMessageSizeLimit'");
        }

        @Override
        public List<WebSocketExtension> getExtensions() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'getExtensions'");
        }

        @Override
        public void sendMessage(WebSocketMessage<?> message) throws IOException {
            consumer.accept(this, message);
        }

        @Override
        public boolean isOpen() {
            return true;
        }

        @Override
        public void close() throws IOException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'close'");
        }

        @Override
        public void close(CloseStatus status) throws IOException {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'close'");
        }
    }

}
