package io.u2ware.ocpp.v2_0_1.handlers;

import io.u2ware.ocpp.v2_0_1.actions.SetVariablesAnswer;
import io.u2ware.ocpp.v2_0_1.actions.SetVariablesOffer;

public interface A01 {
   
    public interface ChargingStationFeature extends SetVariablesAnswer, A01, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] name() { return new String[]{"A01"};}

    }

    public interface CSMSHandler extends SetVariablesOffer, A01, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        default String[] name() { return new String[]{"A01"};}

    }
}