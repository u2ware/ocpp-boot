package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.ReportDERControlRequest;
import io.u2ware.ocpp.v2_1.model.ReportDERControlResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ReportDERControlOffer { 

    public ReportDERControlRequest sendReportDERControlRequest(String id, Map<String,Object> req);

    public void receivedReportDERControlResponse(String id, ReportDERControlResponse res, ErrorCode err);

}