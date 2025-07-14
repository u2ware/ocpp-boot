package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.UnlockConnectorRequest;
import io.u2ware.ocpp.v1_6.model.UnlockConnectorResponse;

public interface UnlockConnectorOffer { 

    public UnlockConnectorRequest sendUnlockConnectorRequest(String id, Map<String,Object> req);

    public void receivedUnlockConnectorResponse(String id, UnlockConnectorResponse res, ErrorCode err);

}