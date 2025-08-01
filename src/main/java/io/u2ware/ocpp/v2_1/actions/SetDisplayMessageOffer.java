package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.SetDisplayMessageRequest;
import io.u2ware.ocpp.v2_1.model.SetDisplayMessageResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SetDisplayMessageOffer { 

    public SetDisplayMessageRequest sendSetDisplayMessageRequest(String id, Map<String,Object> req);

    public void receivedSetDisplayMessageResponse(String id, SetDisplayMessageResponse res, ErrorCode err);

}