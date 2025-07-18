package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.RequestBatterySwapRequest;
import io.u2ware.ocpp.v2_1.model.RequestBatterySwapResponse;

public interface RequestBatterySwapAnswer { 

    public RequestBatterySwapResponse receivedRequestBatterySwapRequest(String id, RequestBatterySwapRequest req);

    public void sendRequestBatterySwapResponse(String id, RequestBatterySwapResponse res, ErrorCode err);

}