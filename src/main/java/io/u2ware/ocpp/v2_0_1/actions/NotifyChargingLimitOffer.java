package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.NotifyChargingLimitRequest;
import io.u2ware.ocpp.v2_0_1.model.NotifyChargingLimitResponse;

public interface NotifyChargingLimitOffer { 

    public NotifyChargingLimitRequest sendNotifyChargingLimitRequest(String id, Map<String,Object> req);

    public void receivedNotifyChargingLimitResponse(String id, NotifyChargingLimitResponse res, ErrorCode err);

}