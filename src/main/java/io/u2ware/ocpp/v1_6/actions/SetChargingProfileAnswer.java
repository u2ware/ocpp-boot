package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.SetChargingProfileRequest;
import io.u2ware.ocpp.v1_6.model.SetChargingProfileResponse;

public interface SetChargingProfileAnswer { 

    public SetChargingProfileResponse receivedSetChargingProfileRequest(String id, SetChargingProfileRequest req);

    public void sendSetChargingProfileResponse(String id, SetChargingProfileResponse res, ErrorCode err);

}