package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.BatterySwapRequest;
import io.u2ware.ocpp.v2_1.model.BatterySwapResponse;

public interface BatterySwapOffer { 

    public BatterySwapRequest sendBatterySwapRequest(String id, Map<String,Object> req);

    public void receivedBatterySwapResponse(String id, BatterySwapResponse res, ErrorCode err);

}