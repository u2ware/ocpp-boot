package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.SetDisplayMessageRequest;
import io.u2ware.ocpp.v2_1.model.SetDisplayMessageResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SetDisplayMessageAnswer { 

    public SetDisplayMessageResponse receivedSetDisplayMessageRequest(String id, SetDisplayMessageRequest req);

    public void sendSetDisplayMessageResponse(String id, SetDisplayMessageResponse res, ErrorCode err);

}