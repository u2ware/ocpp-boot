package io.u2ware.ocpp.v2_0_1.handlers;

import io.u2ware.ocpp.v2_0_1.actions.BootNotificationAnswer;
import io.u2ware.ocpp.v2_0_1.actions.BootNotificationOffer;
import io.u2ware.ocpp.v2_0_1.actions.ResetAnswer;
import io.u2ware.ocpp.v2_0_1.actions.ResetOffer;
import io.u2ware.ocpp.v2_0_1.actions.SetVariablesAnswer;
import io.u2ware.ocpp.v2_0_1.actions.SetVariablesOffer;

public interface A05 {
    
    public interface ChargingStationFeature extends SetVariablesAnswer, ResetAnswer, BootNotificationOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] name() { return new String[]{"A05"};}

    }


    public interface CSMSHandler extends SetVariablesOffer, ResetOffer, BootNotificationAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        default String[] name() { return new String[]{"A05"};}

    }

}
