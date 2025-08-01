package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.NotifyDisplayMessagesRequest;
import io.u2ware.ocpp.v2_1.model.NotifyDisplayMessagesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyDisplayMessagesOffer { 

    public NotifyDisplayMessagesRequest sendNotifyDisplayMessagesRequest(String id, Map<String,Object> req);

    public void receivedNotifyDisplayMessagesResponse(String id, NotifyDisplayMessagesResponse res, ErrorCode err);

}