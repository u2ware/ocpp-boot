package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.GetChargingProfilesRequest;
import io.u2ware.ocpp.v2_1.model.GetChargingProfilesResponse;

public interface GetChargingProfilesOffer { 

    public GetChargingProfilesRequest sendGetChargingProfilesRequest(String id, Map<String,Object> req);

    public void receivedGetChargingProfilesResponse(String id, GetChargingProfilesResponse res, ErrorCode err);

}