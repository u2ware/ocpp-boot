package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.HeartbeatRequest;
import io.u2ware.ocpp.v2_1.model.HeartbeatResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface HeartbeatOffer { 

    public HeartbeatRequest sendHeartbeatRequest(String id, Map<String,Object> req);

    public void receivedHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err);

}