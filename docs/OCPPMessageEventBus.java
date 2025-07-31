package io.u2ware.ocpp.test.mock0;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

public class OCPPMessageEventBus {
    

    private GenericApplicationContext ctx;

    public OCPPMessageEventBus(){
        ctx = new GenericApplicationContext();
        ctx.refresh();
    }

    public void subscribeServer(ApplicationListener<ServerEvent> listener) {
        // System.out.println("ServerEventListener");
        ctx.addApplicationListener(listener);
    }
    public void subscribeClient(ApplicationListener<ClientEvent> listener) {
        // System.out.println("ClientEventListener");
        ctx.addApplicationListener(listener);
    }

    public void publishServer(ServerEvent event) {
        // System.out.println("ServerEvent");
        ctx.publishEvent(event);
    }

    public void publishClient(ClientEvent event) {
        // System.out.println("ServerEvent");
        ctx.publishEvent(event);
    }

    public static class ServerEvent extends ApplicationEvent{
        public ServerEvent(String source) {
            super(source);
        }
    }

    public static class ClientEvent extends ApplicationEvent{
        public ClientEvent(String source) {
            super(source);
        }
    }
}
