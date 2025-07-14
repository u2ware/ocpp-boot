package io.u2ware.ocpp.test.mock0;

import org.springframework.context.ApplicationListener;
import org.springframework.util.ClassUtils;

import io.u2ware.ocpp.core.OCPPConsumer;
import io.u2ware.ocpp.core.OCPPConversion;
import io.u2ware.ocpp.core.OCPPMessage;
import io.u2ware.ocpp.core.OCPPOperations;
import io.u2ware.ocpp.test.mock0.SimpleMessageEvent.ClientEvent;
import io.u2ware.ocpp.test.mock0.SimpleMessageEvent.ServerEvent;

public class SimpleMessageTransfer {

    private SimpleMessageEvent messages = new SimpleMessageEvent();
    private OCPPConversion conversion = new OCPPConversion();
    private OCPPOperations server;
    private OCPPOperations client;

    public <T> OCPPConsumer<T> getServerCallback() {
        return new ServerCallback<T>();
    }
    public  <T> OCPPConsumer<T> getClientCallback() {
        return new ClientCallback<T>();
    }

    public OCPPOperations getServer() {
        return server;
    }
    public OCPPOperations getClient() {
        return client;
    }


    public SimpleMessageTransfer(OCPPOperations server, OCPPOperations client){
        
        this.server = server;
        this.client = client;

        messages.subscribeServer(new ServerEventListener());
        messages.subscribeClient(new ClientEventListener());
    }

    public class ServerEventListener implements ApplicationListener<ServerEvent>{
        public void onApplicationEvent(ServerEvent event) {
            String t = (String)event.getSource();
            client.answer(t, (r, u)->{
                if(r == null) return;
                messages.publishClient(new ClientEvent(r));
            });
        }
    }

    public class ClientEventListener implements ApplicationListener<ClientEvent>{
        public void onApplicationEvent(ClientEvent event) {
            String t = (String)event.getSource();
            server.answer(t, (r1, u1)->{
                if(r1 == null) return;
                messages.publishServer(new ServerEvent(r1));
            });
        }
    }

    public class ClientCallback<T> implements OCPPConsumer<T> {
        public void accept(T t, Throwable u) {
            if(t == null) return;

            if(ClassUtils.isAssignableValue(String.class, t)) {
                messages.publishClient(new ClientEvent(t.toString()));

            }else if(ClassUtils.isAssignableValue(OCPPMessage.class, t)) {
                messages.publishClient(new ClientEvent(conversion.convertMessage((OCPPMessage<?>)t)));
            }
        }
    }

    public class ServerCallback<T> implements OCPPConsumer<T> {
        public void accept(T t, Throwable u) {
            if(t == null) return;
            if(ClassUtils.isAssignableValue(String.class, t)) {
                messages.publishServer(new ServerEvent(t.toString()));

            }else if(ClassUtils.isAssignableValue(OCPPMessage.class, t)) {
                messages.publishServer(new ServerEvent(conversion.convertMessage((OCPPMessage<?>)t)));
            }
        }
    }
}
