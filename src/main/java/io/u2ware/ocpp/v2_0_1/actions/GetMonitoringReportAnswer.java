package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.GetMonitoringReportRequest;
import io.u2ware.ocpp.v2_0_1.model.GetMonitoringReportResponse;

public interface GetMonitoringReportAnswer { 

    public GetMonitoringReportResponse receivedGetMonitoringReportRequest(String id, GetMonitoringReportRequest req);

    public void sendGetMonitoringReportResponse(String id, GetMonitoringReportResponse res, ErrorCode err);

}