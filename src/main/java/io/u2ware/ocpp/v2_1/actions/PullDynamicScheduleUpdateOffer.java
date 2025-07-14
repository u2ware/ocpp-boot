package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.PullDynamicScheduleUpdateRequest;
import io.u2ware.ocpp.v2_1.model.PullDynamicScheduleUpdateResponse;

public interface PullDynamicScheduleUpdateOffer { 

    public PullDynamicScheduleUpdateRequest sendPullDynamicScheduleUpdateRequest(String id, Map<String,Object> req);

    public void receivedPullDynamicScheduleUpdateResponse(String id, PullDynamicScheduleUpdateResponse res, ErrorCode err);

}