package io.u2ware.ocpp.test.mock0;

import org.springframework.context.ApplicationListener;
import org.springframework.util.ClassUtils;

import io.u2ware.ocpp.core.OCPPConsumer;
import io.u2ware.ocpp.core.OCPPConversion;
import io.u2ware.ocpp.core.OCPPMessage;
import io.u2ware.ocpp.core.OCPPFeatureOperations;
import io.u2ware.ocpp.test.mock0.OCPPMessageEventBus.ClientEvent;
import io.u2ware.ocpp.test.mock0.OCPPMessageEventBus.ServerEvent;

public class OCPPMessageEventBusInvoker {

    private OCPPMessageEventBus messages = new OCPPMessageEventBus();
    private OCPPConversion conversion = new OCPPConversion();
    private OCPPFeatureOperations server;
    private OCPPFeatureOperations client;

    public <T> OCPPConsumer<T> getServerCallback() {
        return new ServerCallback<T>();
    }
    public  <T> OCPPConsumer<T> getClientCallback() {
        return new ClientCallback<T>();
    }

    public OCPPFeatureOperations getServer() {
        return server;
    }
    public OCPPFeatureOperations getClient() {
        return client;
    }


    public OCPPMessageEventBusInvoker(OCPPFeatureOperations server, OCPPFeatureOperations client){
        
        this.server = server;
        this.client = client;

        messages.subscribeServer(new ServerEventListener());
        messages.subscribeClient(new ClientEventListener());
    }

    public class ServerEventListener implements ApplicationListener<ServerEvent>{
        public void onApplicationEvent(ServerEvent event) {
            String json = (String)event.getSource();
            OCPPMessage<?> t = conversion.convertMessage(json);
            client.answer(t, (r, u)->{
                if(r == null) return;
                messages.publishClient(new ClientEvent(conversion.convertMessage(r)));
            });
        }
    }

    public class ClientEventListener implements ApplicationListener<ClientEvent>{
        public void onApplicationEvent(ClientEvent event) {
            String json = (String)event.getSource();
            OCPPMessage<?> t = conversion.convertMessage(json);
            server.answer(t, (r, u)->{
                if(r == null) return;
                messages.publishServer(new ServerEvent(conversion.convertMessage(r)));
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
