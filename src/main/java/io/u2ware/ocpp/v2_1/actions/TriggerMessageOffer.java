package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.TriggerMessageRequest;
import io.u2ware.ocpp.v2_1.model.TriggerMessageResponse;

public interface TriggerMessageOffer { 

    public TriggerMessageRequest sendTriggerMessageRequest(String id, Map<String,Object> req);

    public void receivedTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err);

}