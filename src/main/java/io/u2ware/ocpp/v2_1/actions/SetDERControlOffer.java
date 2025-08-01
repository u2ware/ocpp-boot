package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.SetDERControlRequest;
import io.u2ware.ocpp.v2_1.model.SetDERControlResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SetDERControlOffer { 

    public SetDERControlRequest sendSetDERControlRequest(String id, Map<String,Object> req);

    public void receivedSetDERControlResponse(String id, SetDERControlResponse res, ErrorCode err);

}