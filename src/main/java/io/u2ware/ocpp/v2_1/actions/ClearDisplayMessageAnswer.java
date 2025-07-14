package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ClearDisplayMessageRequest;
import io.u2ware.ocpp.v2_1.model.ClearDisplayMessageResponse;

public interface ClearDisplayMessageAnswer { 

    public ClearDisplayMessageResponse receivedClearDisplayMessageRequest(String id, ClearDisplayMessageRequest req);

    public void sendClearDisplayMessageResponse(String id, ClearDisplayMessageResponse res, ErrorCode err);

}