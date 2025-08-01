package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.GetDERControlRequest;
import io.u2ware.ocpp.v2_1.model.GetDERControlResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetDERControlOffer { 

    public GetDERControlRequest sendGetDERControlRequest(String id, Map<String,Object> req);

    public void receivedGetDERControlResponse(String id, GetDERControlResponse res, ErrorCode err);

}