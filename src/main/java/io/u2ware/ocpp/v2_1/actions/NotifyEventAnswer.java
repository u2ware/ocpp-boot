package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyEventRequest;
import io.u2ware.ocpp.v2_1.model.NotifyEventResponse;

public interface NotifyEventAnswer { 

    public NotifyEventResponse receivedNotifyEventRequest(String id, NotifyEventRequest req);

    public void sendNotifyEventResponse(String id, NotifyEventResponse res, ErrorCode err);

}