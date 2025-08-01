package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.HeartbeatRequest;
import io.u2ware.ocpp.v2_1.model.HeartbeatResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface HeartbeatAnswer { 

    public HeartbeatResponse receivedHeartbeatRequest(String id, HeartbeatRequest req);

    public void sendHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err);

}