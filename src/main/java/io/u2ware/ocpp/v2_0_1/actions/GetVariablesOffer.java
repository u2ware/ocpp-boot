package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.GetVariablesRequest;
import io.u2ware.ocpp.v2_0_1.model.GetVariablesResponse;

public interface GetVariablesOffer { 

    public GetVariablesRequest sendGetVariablesRequest(String id, Map<String,Object> req);

    public void receivedGetVariablesResponse(String id, GetVariablesResponse res, ErrorCode err);

}