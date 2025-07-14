package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyChargingLimitRequest;
import io.u2ware.ocpp.v2_1.model.NotifyChargingLimitResponse;

public interface NotifyChargingLimitAnswer { 

    public NotifyChargingLimitResponse receivedNotifyChargingLimitRequest(String id, NotifyChargingLimitRequest req);

    public void sendNotifyChargingLimitResponse(String id, NotifyChargingLimitResponse res, ErrorCode err);

}