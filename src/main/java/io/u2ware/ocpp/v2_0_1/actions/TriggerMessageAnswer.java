package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.TriggerMessageRequest;
import io.u2ware.ocpp.v2_0_1.model.TriggerMessageResponse;

public interface TriggerMessageAnswer { 

    public TriggerMessageResponse receivedTriggerMessageRequest(String id, TriggerMessageRequest req);

    public void sendTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err);

}