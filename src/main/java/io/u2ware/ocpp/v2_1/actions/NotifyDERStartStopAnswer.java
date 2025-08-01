package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.NotifyDERStartStopRequest;
import io.u2ware.ocpp.v2_1.model.NotifyDERStartStopResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyDERStartStopAnswer { 

    public NotifyDERStartStopResponse receivedNotifyDERStartStopRequest(String id, NotifyDERStartStopRequest req);

    public void sendNotifyDERStartStopResponse(String id, NotifyDERStartStopResponse res, ErrorCode err);

}