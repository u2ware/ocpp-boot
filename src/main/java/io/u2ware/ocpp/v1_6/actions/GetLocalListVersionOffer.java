package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.GetLocalListVersionRequest;
import io.u2ware.ocpp.v1_6.model.GetLocalListVersionResponse;

public interface GetLocalListVersionOffer { 

    public GetLocalListVersionRequest sendGetLocalListVersionRequest(String id, Map<String,Object> req);

    public void receivedGetLocalListVersionResponse(String id, GetLocalListVersionResponse res, ErrorCode err);

}