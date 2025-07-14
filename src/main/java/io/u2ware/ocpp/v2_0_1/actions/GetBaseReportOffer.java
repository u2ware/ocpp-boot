package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.GetBaseReportRequest;
import io.u2ware.ocpp.v2_0_1.model.GetBaseReportResponse;

public interface GetBaseReportOffer { 

    public GetBaseReportRequest sendGetBaseReportRequest(String id, Map<String,Object> req);

    public void receivedGetBaseReportResponse(String id, GetBaseReportResponse res, ErrorCode err);

}