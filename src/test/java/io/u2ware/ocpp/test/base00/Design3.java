package io.u2ware.ocpp.test.base00;


import io.u2ware.ocpp.v1_6.actions.*;


public class Design3 {
    

   
    // public interface Usecase1 extends AuthorizeOffer, AuthorizeAnswer{
    
    // }    

    // public interface Usecase2 extends BootNotificationOffer, BootNotificationAnswer{
    
    // }        
    public interface Usecase3 extends AuthorizeOffer, BootNotificationOffer {
    
    }
    public interface Usecase4 extends AuthorizeOffer, BootNotificationAnswer{
    
    }
    public interface Usecase5 extends AuthorizeAnswer, BootNotificationAnswer{

    }
    public interface Usecase6 extends AuthorizeAnswer, BootNotificationOffer{
        //duplicate
    }


    // public class Usecase11 implements AuthorizeOffer, AuthorizeAnswer{
       
    // }


}
