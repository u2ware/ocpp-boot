package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.UnlockConnectorRequest;
import io.u2ware.ocpp.v1_6.model.UnlockConnectorResponse;

public interface UnlockConnectorAnswer { 

    public UnlockConnectorResponse receivedUnlockConnectorRequest(String id, UnlockConnectorRequest req);

    public void sendUnlockConnectorResponse(String id, UnlockConnectorResponse res, ErrorCode err);

}