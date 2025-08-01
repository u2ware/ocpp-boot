package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.NotifyPriorityChargingRequest;
import io.u2ware.ocpp.v2_1.model.NotifyPriorityChargingResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyPriorityChargingAnswer { 

    public NotifyPriorityChargingResponse receivedNotifyPriorityChargingRequest(String id, NotifyPriorityChargingRequest req);

    public void sendNotifyPriorityChargingResponse(String id, NotifyPriorityChargingResponse res, ErrorCode err);

}