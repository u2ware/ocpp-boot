package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.SetChargingProfileRequest;
import io.u2ware.ocpp.v2_1.model.SetChargingProfileResponse;

public interface SetChargingProfileAnswer { 

    public SetChargingProfileResponse receivedSetChargingProfileRequest(String id, SetChargingProfileRequest req);

    public void sendSetChargingProfileResponse(String id, SetChargingProfileResponse res, ErrorCode err);

}