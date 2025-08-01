package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.UsePriorityChargingRequest;
import io.u2ware.ocpp.v2_1.model.UsePriorityChargingResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface UsePriorityChargingAnswer { 

    public UsePriorityChargingResponse receivedUsePriorityChargingRequest(String id, UsePriorityChargingRequest req);

    public void sendUsePriorityChargingResponse(String id, UsePriorityChargingResponse res, ErrorCode err);

}