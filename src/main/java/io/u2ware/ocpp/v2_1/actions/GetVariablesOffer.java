package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.GetVariablesRequest;
import io.u2ware.ocpp.v2_1.model.GetVariablesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetVariablesOffer { 

    public GetVariablesRequest sendGetVariablesRequest(String id, Map<String,Object> req);

    public void receivedGetVariablesResponse(String id, GetVariablesResponse res, ErrorCode err);

}