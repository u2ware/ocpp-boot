package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.NotifyPeriodicEventStreamResponse;

public interface NotifyPeriodicEventStreamOffer {
    
    public NotifyPeriodicEventStreamRequest sendNotifyPeriodicEventStreamRequest(String id, Map<String,Object> req);

    public void receivedNotifyPeriodicEventStreamResponse(String id, NotifyPeriodicEventStreamResponse res, ErrorCode err);
}
