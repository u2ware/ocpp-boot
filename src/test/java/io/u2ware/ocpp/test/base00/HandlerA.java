package io.u2ware.ocpp.test.base00;

import io.u2ware.ocpp.v1_6.actions.AuthorizeOffer;

public interface HandlerA {
    
    public interface ChargePointHandler extends AuthorizeOffer, Handler {
    
        // default String usecase(){
        //     return null;
        // }
        // default Boolean action(){
        //     return Boolean.TRUE;
        // }

    }

}
