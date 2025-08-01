package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.GetVariablesRequest;
import io.u2ware.ocpp.v2_1.model.GetVariablesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetVariablesAnswer { 

    public GetVariablesResponse receivedGetVariablesRequest(String id, GetVariablesRequest req);

    public void sendGetVariablesResponse(String id, GetVariablesResponse res, ErrorCode err);

}