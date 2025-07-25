package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ReportDERControlRequest;
import io.u2ware.ocpp.v2_1.model.ReportDERControlResponse;

public interface ReportDERControlAnswer { 

    public ReportDERControlResponse receivedReportDERControlRequest(String id, ReportDERControlRequest req);

    public void sendReportDERControlResponse(String id, ReportDERControlResponse res, ErrorCode err);

}