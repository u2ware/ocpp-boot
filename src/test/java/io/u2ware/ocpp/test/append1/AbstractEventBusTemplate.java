package io.u2ware.ocpp.test.append1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import io.u2ware.ocpp.OCPPConsumer;
import io.u2ware.ocpp.OCPPConversion;
import io.u2ware.ocpp.OCPPFeatureOperations;
import io.u2ware.ocpp.OCPPMessage;

public abstract class AbstractEventBusTemplate<T extends OCPPFeatureOperations> {
    
	protected Log logger = LogFactory.getLog(getClass());

    protected ConfigurableApplicationContext context;
    protected OCPPConversion conversion = new OCPPConversion();
    protected T operations;


    protected AbstractEventBusTemplate(T operations, ApplicationContext ac){
        this.operations = operations;
        if(ClassUtils.isAssignableValue(ConfigurableApplicationContext.class, ac)) {
            this.context = (ConfigurableApplicationContext)ac;
        }
        Assert.notNull(operations, "actor is null");
        Assert.notNull(context, "context is null");
        this.subscribe();
    }


    protected void subscribe(){
        if(operations.isServer()) {
            context.addApplicationListener(new ClientEventListener());
        }else{
            context.addApplicationListener(new ServerEventListener());
        }        
    }


    protected void answer(String json){        

        OCPPMessage<?> e = conversion.convertMessage(json);

        if(operations.isServer()) {
            operations.answer(e, new ServerEventPublisher());
        }else{
            operations.answer(e, new ClientEventPublisher());
        }        
    }


    protected void publish(String t, Throwable u){
        if(t == null) {
            return;
        }

        if(operations.isServer()) {
            context.publishEvent(new ServerEvent(t));
        }else{
            context.publishEvent(new ClientEvent(t));
        }
    }
    
    protected String convert(OCPPMessage<?> m){
        try{
            return conversion.convertMessage(m);
        }catch(Exception e){
            return null;
        }
    }

    public class ServerEventListener implements ApplicationListener<ServerEvent>{
        public void onApplicationEvent(ServerEvent event) {
            answer((String)event.getSource());
        }
    }

    public class ClientEventListener implements ApplicationListener<ClientEvent>{
        public void onApplicationEvent(ClientEvent event) {
            answer((String)event.getSource());
        }
    }

    public class ClientEventPublisher implements OCPPConsumer<OCPPMessage<?>> {
        public void accept(OCPPMessage<?> t, Throwable u) {
            publish(convert(t), u);
        }
    }

    public class ServerEventPublisher implements OCPPConsumer<OCPPMessage<?>> {
        public void accept(OCPPMessage<?> t, Throwable u) {
            publish(convert(t), u);
        }
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


    public OCPPConsumer<OCPPMessage<?>> getClientCallback(){
        return new ClientEventPublisher();
    }
    
    public OCPPConsumer<OCPPMessage<?>> getServerCallback(){
        return new ServerEventPublisher();
    }
}
