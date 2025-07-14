package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ClearDERControlRequest;
import io.u2ware.ocpp.v2_1.model.ClearDERControlResponse;

public interface ClearDERControlAnswer { 

    public ClearDERControlResponse receivedClearDERControlRequest(String id, ClearDERControlRequest req);

    public void sendClearDERControlResponse(String id, ClearDERControlResponse res, ErrorCode err);

}