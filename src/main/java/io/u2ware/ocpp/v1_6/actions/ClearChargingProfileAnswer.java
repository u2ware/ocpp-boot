package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.ClearChargingProfileRequest;
import io.u2ware.ocpp.v1_6.model.ClearChargingProfileResponse;

public interface ClearChargingProfileAnswer { 

    public ClearChargingProfileResponse receivedClearChargingProfileRequest(String id, ClearChargingProfileRequest req);

    public void sendClearChargingProfileResponse(String id, ClearChargingProfileResponse res, ErrorCode err);

}