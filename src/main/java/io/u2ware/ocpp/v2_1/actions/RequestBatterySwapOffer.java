package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.RequestBatterySwapRequest;
import io.u2ware.ocpp.v2_1.model.RequestBatterySwapResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface RequestBatterySwapOffer { 

    public RequestBatterySwapRequest sendRequestBatterySwapRequest(String id, Map<String,Object> req);

    public void receivedRequestBatterySwapResponse(String id, RequestBatterySwapResponse res, ErrorCode err);

}