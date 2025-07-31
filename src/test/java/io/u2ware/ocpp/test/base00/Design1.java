package io.u2ware.ocpp.test.base00;

import java.util.Date;


// import io.u2ware.ocpp.specifications.v1_6.actions.*;
// import io.u2ware.ocpp.specifications.v1_6.exception.ErrorCode;
// import io.u2ware.ocpp.specifications.v1_6.model.*;

public class Design1  {

    
    public interface Sender<Req,Res>  {
        public Req sendRequest(Object options);
        public void receivedResponse(Res res, String err);
        // public void check(Req payload);        
    }

    public interface Receiver<Req,Res>  {
        public Res receivedRequest(Req options);
        public void sendResponse(Res res, String err);        
        // public void check(Req payload);        
    }


    public interface ASender extends Sender<String,Number>  {

    }

    public interface AReceiver extends Receiver<String,Number>  {

    }

    public interface BSender extends Sender<Long,Date>  {

    }

    public interface BReceiver extends Receiver<Long,Date>  {

    }


    public interface Usecase1 extends ASender, AReceiver{
    
    }
    public interface Usecase2 extends BSender, BReceiver{
    
    }    
    // public interface Usecase3 extends ASender, BSender{
    
    // }
    public interface Usecase4 extends ASender, BReceiver{
    
    }
    public interface Usecase5 extends AReceiver, BSender{

    }
    // public interface Usecase6 extends AReceiver, BReceiver{
    //     //duplicate
    // }
}
