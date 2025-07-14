package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.HeartbeatRequest;
import io.u2ware.ocpp.v1_6.model.HeartbeatResponse;

public interface HeartbeatOffer { 

    public HeartbeatRequest sendHeartbeatRequest(String id, Map<String,Object> req);

    public void receivedHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err);

}