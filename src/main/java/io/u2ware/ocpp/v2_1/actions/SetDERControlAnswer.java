package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.SetDERControlRequest;
import io.u2ware.ocpp.v2_1.model.SetDERControlResponse;

public interface SetDERControlAnswer { 

    public SetDERControlResponse receivedSetDERControlRequest(String id, SetDERControlRequest req);

    public void sendSetDERControlResponse(String id, SetDERControlResponse res, ErrorCode err);

}