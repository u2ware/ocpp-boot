package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.NotifyPeriodicEventStreamResponse;

public interface NotifyPeriodicEventStreamAnswer {
    
    public NotifyPeriodicEventStreamResponse receivedNotifyPeriodicEventStreamRequest(String id, NotifyPeriodicEventStreamRequest req);

    public void sendNotifyPeriodicEventStreamResponse(String id, NotifyPeriodicEventStreamResponse res, ErrorCode err);
}
