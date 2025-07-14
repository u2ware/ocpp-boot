package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.ClearDisplayMessageRequest;
import io.u2ware.ocpp.v2_0_1.model.ClearDisplayMessageResponse;

public interface ClearDisplayMessageOffer { 

    public ClearDisplayMessageRequest sendClearDisplayMessageRequest(String id, Map<String,Object> req);

    public void receivedClearDisplayMessageResponse(String id, ClearDisplayMessageResponse res, ErrorCode err);

}