package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.UpdateDynamicScheduleRequest;
import io.u2ware.ocpp.v2_1.model.UpdateDynamicScheduleResponse;

public interface UpdateDynamicScheduleAnswer { 

    public UpdateDynamicScheduleResponse receivedUpdateDynamicScheduleRequest(String id, UpdateDynamicScheduleRequest req);

    public void sendUpdateDynamicScheduleResponse(String id, UpdateDynamicScheduleResponse res, ErrorCode err);

}