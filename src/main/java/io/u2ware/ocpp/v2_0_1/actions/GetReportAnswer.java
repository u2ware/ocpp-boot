package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.GetReportRequest;
import io.u2ware.ocpp.v2_0_1.model.GetReportResponse;

public interface GetReportAnswer { 

    public GetReportResponse receivedGetReportRequest(String id, GetReportRequest req);

    public void sendGetReportResponse(String id, GetReportResponse res, ErrorCode err);

}