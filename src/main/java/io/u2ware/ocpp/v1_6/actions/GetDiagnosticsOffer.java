package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.GetDiagnosticsRequest;
import io.u2ware.ocpp.v1_6.model.GetDiagnosticsResponse;

public interface GetDiagnosticsOffer { 

    public GetDiagnosticsRequest sendGetDiagnosticsRequest(String id, Map<String,Object> req);

    public void receivedGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err);

}