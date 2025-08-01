package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.GetPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.GetPeriodicEventStreamResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetPeriodicEventStreamOffer { 

    public GetPeriodicEventStreamRequest sendGetPeriodicEventStreamRequest(String id, Map<String,Object> req);

    public void receivedGetPeriodicEventStreamResponse(String id, GetPeriodicEventStreamResponse res, ErrorCode err);

}