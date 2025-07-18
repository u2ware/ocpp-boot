package io.u2ware.ocpp.test.mock0;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.u2ware.ocpp.core.OCPPConsumer;
import io.u2ware.ocpp.core.OCPPMessage;


public class SimpleMessageCallback implements OCPPConsumer<OCPPMessage<?>>{

    protected final Log logger = LogFactory.getLog(getClass());


    private OCPPMessage<?> msg;
    private Throwable err;

    public SimpleMessageCallback(){

    }

    @Override
    public void accept(OCPPMessage<?> m, Throwable u) {
        this.msg = m;
        this.err = u;    
    }

    public OCPPMessage<?> getMsg() {
        return msg;
    }

    public Throwable getErr() {
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

