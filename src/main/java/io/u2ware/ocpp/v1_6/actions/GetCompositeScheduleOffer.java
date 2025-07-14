package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.GetCompositeScheduleRequest;
import io.u2ware.ocpp.v1_6.model.GetCompositeScheduleResponse;

public interface GetCompositeScheduleOffer { 

    public GetCompositeScheduleRequest sendGetCompositeScheduleRequest(String id, Map<String,Object> req);

    public void receivedGetCompositeScheduleResponse(String id, GetCompositeScheduleResponse res, ErrorCode err);

}