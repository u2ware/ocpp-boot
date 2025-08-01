package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.UpdateDynamicScheduleRequest;
import io.u2ware.ocpp.v2_1.model.UpdateDynamicScheduleResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface UpdateDynamicScheduleOffer { 

    public UpdateDynamicScheduleRequest sendUpdateDynamicScheduleRequest(String id, Map<String,Object> req);

    public void receivedUpdateDynamicScheduleResponse(String id, UpdateDynamicScheduleResponse res, ErrorCode err);

}