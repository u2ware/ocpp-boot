package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.ClearChargingProfileRequest;
import io.u2ware.ocpp.v2_0_1.model.ClearChargingProfileResponse;

public interface ClearChargingProfileOffer { 

    public ClearChargingProfileRequest sendClearChargingProfileRequest(String id, Map<String,Object> req);

    public void receivedClearChargingProfileResponse(String id, ClearChargingProfileResponse res, ErrorCode err);

}