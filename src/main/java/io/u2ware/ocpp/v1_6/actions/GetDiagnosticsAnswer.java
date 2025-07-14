package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.GetDiagnosticsRequest;
import io.u2ware.ocpp.v1_6.model.GetDiagnosticsResponse;

public interface GetDiagnosticsAnswer { 

    public GetDiagnosticsResponse receivedGetDiagnosticsRequest(String id, GetDiagnosticsRequest req);

    public void sendGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err);

}