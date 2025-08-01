package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.GetReportRequest;
import io.u2ware.ocpp.v2_1.model.GetReportResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetReportAnswer { 

    public GetReportResponse receivedGetReportRequest(String id, GetReportRequest req);

    public void sendGetReportResponse(String id, GetReportResponse res, ErrorCode err);

}