package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.AdjustPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.AdjustPeriodicEventStreamResponse;

public interface AdjustPeriodicEventStreamAnswer { 

    public AdjustPeriodicEventStreamResponse receivedAdjustPeriodicEventStreamRequest(String id, AdjustPeriodicEventStreamRequest req);

    public void sendAdjustPeriodicEventStreamResponse(String id, AdjustPeriodicEventStreamResponse res, ErrorCode err);

}