package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ClearDERControlRequest;
import io.u2ware.ocpp.v2_1.model.ClearDERControlResponse;

public interface ClearDERControlOffer { 

    public ClearDERControlRequest sendClearDERControlRequest(String id, Map<String,Object> req);

    public void receivedClearDERControlResponse(String id, ClearDERControlResponse res, ErrorCode err);

}