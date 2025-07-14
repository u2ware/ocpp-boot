package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.GetLocalListVersionRequest;
import io.u2ware.ocpp.v1_6.model.GetLocalListVersionResponse;

public interface GetLocalListVersionAnswer { 

    public GetLocalListVersionResponse receivedGetLocalListVersionRequest(String id, GetLocalListVersionRequest req);

    public void sendGetLocalListVersionResponse(String id, GetLocalListVersionResponse res, ErrorCode err);

}