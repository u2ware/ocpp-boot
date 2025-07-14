package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.GetChargingProfilesRequest;
import io.u2ware.ocpp.v2_1.model.GetChargingProfilesResponse;

public interface GetChargingProfilesAnswer { 

    public GetChargingProfilesResponse receivedGetChargingProfilesRequest(String id, GetChargingProfilesRequest req);

    public void sendGetChargingProfilesResponse(String id, GetChargingProfilesResponse res, ErrorCode err);

}