package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.TriggerMessageRequest;
import io.u2ware.ocpp.v1_6.model.TriggerMessageResponse;

public interface TriggerMessageAnswer { 

    public TriggerMessageResponse receivedTriggerMessageRequest(String id, TriggerMessageRequest req);

    public void sendTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err);

}