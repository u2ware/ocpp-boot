package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.SetVariablesRequest;
import io.u2ware.ocpp.v2_0_1.model.SetVariablesResponse;

public interface SetVariablesAnswer { 

    public SetVariablesResponse receivedSetVariablesRequest(String id, SetVariablesRequest req);

    public void sendSetVariablesResponse(String id, SetVariablesResponse res, ErrorCode err);

}