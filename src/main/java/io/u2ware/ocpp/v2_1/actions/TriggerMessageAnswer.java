package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.TriggerMessageRequest;
import io.u2ware.ocpp.v2_1.model.TriggerMessageResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface TriggerMessageAnswer { 

    public TriggerMessageResponse receivedTriggerMessageRequest(String id, TriggerMessageRequest req);

    public void sendTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err);

}