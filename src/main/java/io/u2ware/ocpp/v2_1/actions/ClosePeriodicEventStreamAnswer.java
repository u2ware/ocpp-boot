package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ClosePeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.ClosePeriodicEventStreamResponse;

public interface ClosePeriodicEventStreamAnswer { 

    public ClosePeriodicEventStreamResponse receivedClosePeriodicEventStreamRequest(String id, ClosePeriodicEventStreamRequest req);

    public void sendClosePeriodicEventStreamResponse(String id, ClosePeriodicEventStreamResponse res, ErrorCode err);

}