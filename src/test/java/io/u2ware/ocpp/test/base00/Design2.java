package io.u2ware.ocpp.test.base00;

import java.util.Date;

import com.fasterxml.jackson.databind.JsonNode;


public class Design2 {
    

    public interface ASender   {
        public String sendAuthorizeRequest(JsonNode options);
        public void receivedAuthorizeResponse(Number res, String err);
        public ASender caugthAuthorizeReflection(Exception e);
        // ASender checkAuthorizeException(Exception obj);
        // default ASender checkAuthorizeActionException(Exception obj){return this;}
    }

    public interface AReceiver   {
        public Number receivedAuthorizeRequest(String options);
        public void sendAuthorizeResponse(Number res, String err);          
        // public void catchAuthorizeActionException(Exception e);
        AReceiver caugthAuthorizeReflection(Exception obj);
        // default AReceiver caugthAuthorizeReflection(Exception obj){return this;}
    }

    public interface BSender  {
        public Long sendBootNotificationRequest(Object options);
        public void receivedBootNotificationResponse(Date res, String err);
    }

    public interface BReceiver  {
        public Date receivedBootNotificationRequest(Long req);
        public void sendBootNotificationResponse(Date res, String err);  

    }

    // public interface Usecase1 extends ASender, AReceiver{
    
    // }
    public interface Usecase2 extends BSender, BReceiver{
    
    }    
    public interface Usecase3 extends ASender, BSender{
    
    }
    public interface Usecase4 extends ASender, BReceiver{
    
    }
    public interface Usecase5 extends AReceiver, BSender{

    }
    public interface Usecase6 extends AReceiver, BReceiver{
        //duplicate
    }


    // public class Usecase11 implements ASender, AReceiver{

    //     @Override
    //     public AuthorizeResponse receivedAuthorizeRequest(AuthorizeRequest options) {
    //         // TODO Auto-generated method stub
    //         throw new UnsupportedOperationException("Unimplemented method 'receivedAuthorizeRequest'");
    //     }

    //     @Override
    //     public void sendAuthorizeResponse(AuthorizeResponse res, ErrorCode err) {
    //         // TODO Auto-generated method stub
    //         throw new UnsupportedOperationException("Unimplemented method 'sendAuthorizeResponse'");
    //     }

    //     @Override
    //     public AReceiver caugthAuthorizeReflection(Exception obj) {
    //         // TODO Auto-generated method stub
    //         throw new UnsupportedOperationException("Unimplemented method 'caugthAuthorizeReflection'");
    //     }

    //     @Override
    //     public AuthorizeRequest sendAuthorizeRequest(JsonNode options) {
    //         // TODO Auto-generated method stub
    //         throw new UnsupportedOperationException("Unimplemented method 'sendAuthorizeRequest'");
    //     }

    //     @Override
    //     public void receivedAuthorizeResponse(AuthorizeResponse res, ErrorCode err) {
    //         // TODO Auto-generated method stub
    //         throw new UnsupportedOperationException("Unimplemented method 'receivedAuthorizeResponse'");
    //     }

       
    // }


}
