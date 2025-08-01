package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.GetPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.GetPeriodicEventStreamResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetPeriodicEventStreamAnswer { 

    public GetPeriodicEventStreamResponse receivedGetPeriodicEventStreamRequest(String id, GetPeriodicEventStreamRequest req);

    public void sendGetPeriodicEventStreamResponse(String id, GetPeriodicEventStreamResponse res, ErrorCode err);

}