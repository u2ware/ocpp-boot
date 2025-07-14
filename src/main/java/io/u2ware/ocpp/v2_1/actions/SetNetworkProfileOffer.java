package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.SetNetworkProfileRequest;
import io.u2ware.ocpp.v2_1.model.SetNetworkProfileResponse;

public interface SetNetworkProfileOffer { 

    public SetNetworkProfileRequest sendSetNetworkProfileRequest(String id, Map<String,Object> req);

    public void receivedSetNetworkProfileResponse(String id, SetNetworkProfileResponse res, ErrorCode err);

}