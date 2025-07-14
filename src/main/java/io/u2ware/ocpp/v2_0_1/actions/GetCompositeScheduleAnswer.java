package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.GetCompositeScheduleRequest;
import io.u2ware.ocpp.v2_0_1.model.GetCompositeScheduleResponse;

public interface GetCompositeScheduleAnswer { 

    public GetCompositeScheduleResponse receivedGetCompositeScheduleRequest(String id, GetCompositeScheduleRequest req);

    public void sendGetCompositeScheduleResponse(String id, GetCompositeScheduleResponse res, ErrorCode err);

}