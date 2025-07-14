package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.OpenPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.OpenPeriodicEventStreamResponse;

public interface OpenPeriodicEventStreamAnswer { 

    public OpenPeriodicEventStreamResponse receivedOpenPeriodicEventStreamRequest(String id, OpenPeriodicEventStreamRequest req);

    public void sendOpenPeriodicEventStreamResponse(String id, OpenPeriodicEventStreamResponse res, ErrorCode err);

}