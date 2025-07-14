package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.AdjustPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.AdjustPeriodicEventStreamResponse;

public interface AdjustPeriodicEventStreamOffer { 

    public AdjustPeriodicEventStreamRequest sendAdjustPeriodicEventStreamRequest(String id, Map<String,Object> req);

    public void receivedAdjustPeriodicEventStreamResponse(String id, AdjustPeriodicEventStreamResponse res, ErrorCode err);

}