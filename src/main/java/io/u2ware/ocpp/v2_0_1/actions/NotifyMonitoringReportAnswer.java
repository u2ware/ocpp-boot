package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.NotifyMonitoringReportRequest;
import io.u2ware.ocpp.v2_0_1.model.NotifyMonitoringReportResponse;

public interface NotifyMonitoringReportAnswer { 

    public NotifyMonitoringReportResponse receivedNotifyMonitoringReportRequest(String id, NotifyMonitoringReportRequest req);

    public void sendNotifyMonitoringReportResponse(String id, NotifyMonitoringReportResponse res, ErrorCode err);

}