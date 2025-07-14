package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.UnlockConnectorRequest;
import io.u2ware.ocpp.v2_1.model.UnlockConnectorResponse;

public interface UnlockConnectorAnswer { 

    public UnlockConnectorResponse receivedUnlockConnectorRequest(String id, UnlockConnectorRequest req);

    public void sendUnlockConnectorResponse(String id, UnlockConnectorResponse res, ErrorCode err);

}