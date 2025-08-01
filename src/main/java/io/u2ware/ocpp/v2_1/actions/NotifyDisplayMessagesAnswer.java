package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.NotifyDisplayMessagesRequest;
import io.u2ware.ocpp.v2_1.model.NotifyDisplayMessagesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyDisplayMessagesAnswer { 

    public NotifyDisplayMessagesResponse receivedNotifyDisplayMessagesRequest(String id, NotifyDisplayMessagesRequest req);

    public void sendNotifyDisplayMessagesResponse(String id, NotifyDisplayMessagesResponse res, ErrorCode err);

}