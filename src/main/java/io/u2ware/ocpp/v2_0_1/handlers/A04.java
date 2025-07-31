package io.u2ware.ocpp.v2_0_1.handlers;

import io.u2ware.ocpp.v2_0_1.actions.SecurityEventNotificationAnswer;
import io.u2ware.ocpp.v2_0_1.actions.SecurityEventNotificationOffer;

public interface A04 {
    
    public interface ChargingStationFeature extends SecurityEventNotificationOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] name() { return new String[]{"A04"};}

    }

    public interface CSMSFeature extends SecurityEventNotificationAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        default String[] name() { return new String[]{"A04"};}
        
    }
}