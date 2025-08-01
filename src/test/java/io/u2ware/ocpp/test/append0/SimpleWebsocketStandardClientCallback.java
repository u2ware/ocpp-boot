package io.u2ware.ocpp.test.append0;

import java.util.function.BiConsumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.u2ware.ocpp.client.WebsocketStandardClient;

public class SimpleWebsocketStandardClientCallback implements BiConsumer<WebsocketStandardClient,Throwable>{

    protected final Log logger = LogFactory.getLog(getClass());


    private WebsocketStandardClient arg;
    private Throwable err;

    public SimpleWebsocketStandardClientCallback(){

    }



    @Override
    public void accept(WebsocketStandardClient arg, Throwable err) {
        logger.info(arg, err);
        this.arg = arg;
        this.err = err;
    }

    public WebsocketStandardClient arg() {
        return arg;
    }

    public Throwable err() {
        return err;
    }


    public void sleep(long t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } 
    
    
}
