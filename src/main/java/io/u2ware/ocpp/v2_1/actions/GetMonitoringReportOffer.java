package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.GetMonitoringReportRequest;
import io.u2ware.ocpp.v2_1.model.GetMonitoringReportResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetMonitoringReportOffer { 

    public GetMonitoringReportRequest sendGetMonitoringReportRequest(String id, Map<String,Object> req);

    public void receivedGetMonitoringReportResponse(String id, GetMonitoringReportResponse res, ErrorCode err);

}