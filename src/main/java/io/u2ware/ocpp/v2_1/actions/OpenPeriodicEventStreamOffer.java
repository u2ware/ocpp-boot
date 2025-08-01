package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.OpenPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.OpenPeriodicEventStreamResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface OpenPeriodicEventStreamOffer { 

    public OpenPeriodicEventStreamRequest sendOpenPeriodicEventStreamRequest(String id, Map<String,Object> req);

    public void receivedOpenPeriodicEventStreamResponse(String id, OpenPeriodicEventStreamResponse res, ErrorCode err);

}