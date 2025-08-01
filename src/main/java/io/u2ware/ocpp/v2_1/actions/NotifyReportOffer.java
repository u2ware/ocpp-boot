package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.NotifyReportRequest;
import io.u2ware.ocpp.v2_1.model.NotifyReportResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyReportOffer { 

    public NotifyReportRequest sendNotifyReportRequest(String id, Map<String,Object> req);

    public void receivedNotifyReportResponse(String id, NotifyReportResponse res, ErrorCode err);

}