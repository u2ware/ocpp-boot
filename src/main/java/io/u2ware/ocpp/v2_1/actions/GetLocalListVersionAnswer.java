package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.GetLocalListVersionRequest;
import io.u2ware.ocpp.v2_1.model.GetLocalListVersionResponse;

public interface GetLocalListVersionAnswer { 

    public GetLocalListVersionResponse receivedGetLocalListVersionRequest(String id, GetLocalListVersionRequest req);

    public void sendGetLocalListVersionResponse(String id, GetLocalListVersionResponse res, ErrorCode err);

}