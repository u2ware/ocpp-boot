package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.GetLocalListVersionRequest;
import io.u2ware.ocpp.v2_1.model.GetLocalListVersionResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetLocalListVersionAnswer { 

    public GetLocalListVersionResponse receivedGetLocalListVersionRequest(String id, GetLocalListVersionRequest req);

    public void sendGetLocalListVersionResponse(String id, GetLocalListVersionResponse res, ErrorCode err);

}