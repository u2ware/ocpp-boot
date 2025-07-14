package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.GetLogRequest;
import io.u2ware.ocpp.v2_1.model.GetLogResponse;

public interface GetLogOffer { 

    public GetLogRequest sendGetLogRequest(String id, Map<String,Object> req);

    public void receivedGetLogResponse(String id, GetLogResponse res, ErrorCode err);

}