package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.GetLogRequest;
import io.u2ware.ocpp.v2_0_1.model.GetLogResponse;

public interface GetLogAnswer { 

    public GetLogResponse receivedGetLogRequest(String id, GetLogRequest req);

    public void sendGetLogResponse(String id, GetLogResponse res, ErrorCode err);

}