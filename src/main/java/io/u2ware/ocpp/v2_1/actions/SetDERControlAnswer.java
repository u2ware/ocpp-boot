package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.SetDERControlRequest;
import io.u2ware.ocpp.v2_1.model.SetDERControlResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SetDERControlAnswer { 

    public SetDERControlResponse receivedSetDERControlRequest(String id, SetDERControlRequest req);

    public void sendSetDERControlResponse(String id, SetDERControlResponse res, ErrorCode err);

}