package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.GetReportRequest;
import io.u2ware.ocpp.v2_1.model.GetReportResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetReportOffer { 

    public GetReportRequest sendGetReportRequest(String id, Map<String,Object> req);

    public void receivedGetReportResponse(String id, GetReportResponse res, ErrorCode err);

}