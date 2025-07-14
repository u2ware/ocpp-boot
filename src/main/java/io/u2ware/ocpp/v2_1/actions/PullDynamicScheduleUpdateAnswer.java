package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.PullDynamicScheduleUpdateRequest;
import io.u2ware.ocpp.v2_1.model.PullDynamicScheduleUpdateResponse;

public interface PullDynamicScheduleUpdateAnswer { 

    public PullDynamicScheduleUpdateResponse receivedPullDynamicScheduleUpdateRequest(String id, PullDynamicScheduleUpdateRequest req);

    public void sendPullDynamicScheduleUpdateResponse(String id, PullDynamicScheduleUpdateResponse res, ErrorCode err);

}