package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyDERStartStopRequest;
import io.u2ware.ocpp.v2_1.model.NotifyDERStartStopResponse;

public interface NotifyDERStartStopOffer { 

    public NotifyDERStartStopRequest sendNotifyDERStartStopRequest(String id, Map<String,Object> req);

    public void receivedNotifyDERStartStopResponse(String id, NotifyDERStartStopResponse res, ErrorCode err);

}