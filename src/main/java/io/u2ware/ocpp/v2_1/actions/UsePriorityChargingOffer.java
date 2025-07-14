package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.UsePriorityChargingRequest;
import io.u2ware.ocpp.v2_1.model.UsePriorityChargingResponse;

public interface UsePriorityChargingOffer { 

    public UsePriorityChargingRequest sendUsePriorityChargingRequest(String id, Map<String,Object> req);

    public void receivedUsePriorityChargingResponse(String id, UsePriorityChargingResponse res, ErrorCode err);

}