package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.GetDERControlRequest;
import io.u2ware.ocpp.v2_1.model.GetDERControlResponse;

public interface GetDERControlAnswer { 

    public GetDERControlResponse receivedGetDERControlRequest(String id, GetDERControlRequest req);

    public void sendGetDERControlResponse(String id, GetDERControlResponse res, ErrorCode err);

}