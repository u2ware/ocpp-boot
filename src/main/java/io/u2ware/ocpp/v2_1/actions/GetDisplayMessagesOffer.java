package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.GetDisplayMessagesRequest;
import io.u2ware.ocpp.v2_1.model.GetDisplayMessagesResponse;

public interface GetDisplayMessagesOffer { 

    public GetDisplayMessagesRequest sendGetDisplayMessagesRequest(String id, Map<String,Object> req);

    public void receivedGetDisplayMessagesResponse(String id, GetDisplayMessagesResponse res, ErrorCode err);

}