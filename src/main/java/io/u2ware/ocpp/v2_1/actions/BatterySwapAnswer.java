package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.BatterySwapRequest;
import io.u2ware.ocpp.v2_1.model.BatterySwapResponse;

public interface BatterySwapAnswer { 

    public BatterySwapResponse receivedBatterySwapRequest(String id, BatterySwapRequest req);

    public void sendBatterySwapResponse(String id, BatterySwapResponse res, ErrorCode err);

}