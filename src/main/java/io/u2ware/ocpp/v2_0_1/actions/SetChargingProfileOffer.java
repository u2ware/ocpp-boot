package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.SetChargingProfileRequest;
import io.u2ware.ocpp.v2_0_1.model.SetChargingProfileResponse;

public interface SetChargingProfileOffer { 

    public SetChargingProfileRequest sendSetChargingProfileRequest(String id, Map<String,Object> req);

    public void receivedSetChargingProfileResponse(String id, SetChargingProfileResponse res, ErrorCode err);

}