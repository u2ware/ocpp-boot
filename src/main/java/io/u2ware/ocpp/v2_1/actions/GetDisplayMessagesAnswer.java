package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.GetDisplayMessagesRequest;
import io.u2ware.ocpp.v2_1.model.GetDisplayMessagesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetDisplayMessagesAnswer { 

    public GetDisplayMessagesResponse receivedGetDisplayMessagesRequest(String id, GetDisplayMessagesRequest req);

    public void sendGetDisplayMessagesResponse(String id, GetDisplayMessagesResponse res, ErrorCode err);

}