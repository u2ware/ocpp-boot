package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.GetCompositeScheduleRequest;
import io.u2ware.ocpp.v1_6.model.GetCompositeScheduleResponse;

public interface GetCompositeScheduleAnswer { 

    public GetCompositeScheduleResponse receivedGetCompositeScheduleRequest(String id, GetCompositeScheduleRequest req);

    public void sendGetCompositeScheduleResponse(String id, GetCompositeScheduleResponse res, ErrorCode err);

}