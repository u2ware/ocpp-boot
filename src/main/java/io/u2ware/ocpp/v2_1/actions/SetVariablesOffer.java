package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.SetVariablesRequest;
import io.u2ware.ocpp.v2_1.model.SetVariablesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SetVariablesOffer { 

    public SetVariablesRequest sendSetVariablesRequest(String id, Map<String,Object> req);

    public void receivedSetVariablesResponse(String id, SetVariablesResponse res, ErrorCode err);

}