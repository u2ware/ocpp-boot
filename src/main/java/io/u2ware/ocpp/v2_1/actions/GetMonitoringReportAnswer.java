package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.GetMonitoringReportRequest;
import io.u2ware.ocpp.v2_1.model.GetMonitoringReportResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetMonitoringReportAnswer { 

    public GetMonitoringReportResponse receivedGetMonitoringReportRequest(String id, GetMonitoringReportRequest req);

    public void sendGetMonitoringReportResponse(String id, GetMonitoringReportResponse res, ErrorCode err);

}