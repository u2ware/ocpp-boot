package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.GetCompositeScheduleRequest;
import io.u2ware.ocpp.v2_1.model.GetCompositeScheduleResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetCompositeScheduleOffer { 

    public GetCompositeScheduleRequest sendGetCompositeScheduleRequest(String id, Map<String,Object> req);

    public void receivedGetCompositeScheduleResponse(String id, GetCompositeScheduleResponse res, ErrorCode err);

}