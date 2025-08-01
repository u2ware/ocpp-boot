package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.NotifyMonitoringReportRequest;
import io.u2ware.ocpp.v2_1.model.NotifyMonitoringReportResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyMonitoringReportOffer { 

    public NotifyMonitoringReportRequest sendNotifyMonitoringReportRequest(String id, Map<String,Object> req);

    public void receivedNotifyMonitoringReportResponse(String id, NotifyMonitoringReportResponse res, ErrorCode err);

}