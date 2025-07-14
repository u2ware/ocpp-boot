package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyPriorityChargingRequest;
import io.u2ware.ocpp.v2_1.model.NotifyPriorityChargingResponse;

public interface NotifyPriorityChargingOffer { 

    public NotifyPriorityChargingRequest sendNotifyPriorityChargingRequest(String id, Map<String,Object> req);

    public void receivedNotifyPriorityChargingResponse(String id, NotifyPriorityChargingResponse res, ErrorCode err);

}