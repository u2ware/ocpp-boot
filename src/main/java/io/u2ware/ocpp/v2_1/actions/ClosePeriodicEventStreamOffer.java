package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.ClosePeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.ClosePeriodicEventStreamResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ClosePeriodicEventStreamOffer { 

    public ClosePeriodicEventStreamRequest sendClosePeriodicEventStreamRequest(String id, Map<String,Object> req);

    public void receivedClosePeriodicEventStreamResponse(String id, ClosePeriodicEventStreamResponse res, ErrorCode err);

}