package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.GetBaseReportRequest;
import io.u2ware.ocpp.v2_1.model.GetBaseReportResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetBaseReportOffer { 

    public GetBaseReportRequest sendGetBaseReportRequest(String id, Map<String,Object> req);

    public void receivedGetBaseReportResponse(String id, GetBaseReportResponse res, ErrorCode err);

}