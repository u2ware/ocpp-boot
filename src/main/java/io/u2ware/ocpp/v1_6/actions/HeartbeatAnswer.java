package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.HeartbeatRequest;
import io.u2ware.ocpp.v1_6.model.HeartbeatResponse;

public interface HeartbeatAnswer { 

    public HeartbeatResponse receivedHeartbeatRequest(String id, HeartbeatRequest req);

    public void sendHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err);

}