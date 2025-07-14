package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.GetBaseReportRequest;
import io.u2ware.ocpp.v2_1.model.GetBaseReportResponse;

public interface GetBaseReportAnswer { 

    public GetBaseReportResponse receivedGetBaseReportRequest(String id, GetBaseReportRequest req);

    public void sendGetBaseReportResponse(String id, GetBaseReportResponse res, ErrorCode err);

}