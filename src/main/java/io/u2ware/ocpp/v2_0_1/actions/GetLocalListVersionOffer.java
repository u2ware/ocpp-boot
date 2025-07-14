package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.GetLocalListVersionRequest;
import io.u2ware.ocpp.v2_0_1.model.GetLocalListVersionResponse;

public interface GetLocalListVersionOffer { 

    public GetLocalListVersionRequest sendGetLocalListVersionRequest(String id, Map<String,Object> req);

    public void receivedGetLocalListVersionResponse(String id, GetLocalListVersionResponse res, ErrorCode err);

}