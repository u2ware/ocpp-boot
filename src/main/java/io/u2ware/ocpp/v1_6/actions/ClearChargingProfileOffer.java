package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.ClearChargingProfileRequest;
import io.u2ware.ocpp.v1_6.model.ClearChargingProfileResponse;

public interface ClearChargingProfileOffer { 

    public ClearChargingProfileRequest sendClearChargingProfileRequest(String id, Map<String,Object> req);

    public void receivedClearChargingProfileResponse(String id, ClearChargingProfileResponse res, ErrorCode err);

}