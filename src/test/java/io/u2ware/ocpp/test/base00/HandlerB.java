package io.u2ware.ocpp.test.base00;

import io.u2ware.ocpp.v1_6.actions.BootNotificationOffer;

public interface HandlerB {
 
    
        public interface ChargePointHandler extends BootNotificationOffer, Handler {

                // default String usecase(){
                //         return null;
                // }
                // default Boolean action(){
                //         return Boolean.TRUE;
                // }

        }
}
