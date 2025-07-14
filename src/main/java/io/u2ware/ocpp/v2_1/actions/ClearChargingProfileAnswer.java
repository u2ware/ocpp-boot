package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ClearChargingProfileRequest;
import io.u2ware.ocpp.v2_1.model.ClearChargingProfileResponse;

public interface ClearChargingProfileAnswer { 

    public ClearChargingProfileResponse receivedClearChargingProfileRequest(String id, ClearChargingProfileRequest req);

    public void sendClearChargingProfileResponse(String id, ClearChargingProfileResponse res, ErrorCode err);

}