package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.GetCompositeScheduleRequest;
import io.u2ware.ocpp.v2_1.model.GetCompositeScheduleResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetCompositeScheduleAnswer { 

    public GetCompositeScheduleResponse receivedGetCompositeScheduleRequest(String id, GetCompositeScheduleRequest req);

    public void sendGetCompositeScheduleResponse(String id, GetCompositeScheduleResponse res, ErrorCode err);

}