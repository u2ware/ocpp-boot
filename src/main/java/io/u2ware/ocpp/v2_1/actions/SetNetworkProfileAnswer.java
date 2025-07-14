package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.SetNetworkProfileRequest;
import io.u2ware.ocpp.v2_1.model.SetNetworkProfileResponse;

public interface SetNetworkProfileAnswer { 

    public SetNetworkProfileResponse receivedSetNetworkProfileRequest(String id, SetNetworkProfileRequest req);

    public void sendSetNetworkProfileResponse(String id, SetNetworkProfileResponse res, ErrorCode err);

}