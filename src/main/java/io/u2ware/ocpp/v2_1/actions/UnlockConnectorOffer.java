package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.UnlockConnectorRequest;
import io.u2ware.ocpp.v2_1.model.UnlockConnectorResponse;

public interface UnlockConnectorOffer { 

    public UnlockConnectorRequest sendUnlockConnectorRequest(String id, Map<String,Object> req);

    public void receivedUnlockConnectorResponse(String id, UnlockConnectorResponse res, ErrorCode err);

}