package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyReportRequest;
import io.u2ware.ocpp.v2_1.model.NotifyReportResponse;

public interface NotifyReportAnswer { 

    public NotifyReportResponse receivedNotifyReportRequest(String id, NotifyReportRequest req);

    public void sendNotifyReportResponse(String id, NotifyReportResponse res, ErrorCode err);

}