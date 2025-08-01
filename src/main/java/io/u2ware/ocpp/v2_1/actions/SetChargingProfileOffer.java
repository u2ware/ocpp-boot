package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.SetChargingProfileRequest;
import io.u2ware.ocpp.v2_1.model.SetChargingProfileResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SetChargingProfileOffer { 

    public SetChargingProfileRequest sendSetChargingProfileRequest(String id, Map<String,Object> req);

    public void receivedSetChargingProfileResponse(String id, SetChargingProfileResponse res, ErrorCode err);

}