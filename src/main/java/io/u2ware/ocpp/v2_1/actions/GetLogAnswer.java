package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.GetLogRequest;
import io.u2ware.ocpp.v2_1.model.GetLogResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetLogAnswer { 

    public GetLogResponse receivedGetLogRequest(String id, GetLogRequest req);

    public void sendGetLogResponse(String id, GetLogResponse res, ErrorCode err);

}