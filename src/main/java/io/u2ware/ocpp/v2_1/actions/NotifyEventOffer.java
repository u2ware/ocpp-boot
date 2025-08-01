package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.NotifyEventRequest;
import io.u2ware.ocpp.v2_1.model.NotifyEventResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyEventOffer { 

    public NotifyEventRequest sendNotifyEventRequest(String id, Map<String,Object> req);

    public void receivedNotifyEventResponse(String id, NotifyEventResponse res, ErrorCode err);

}