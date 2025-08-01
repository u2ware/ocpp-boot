package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.NotifyChargingLimitRequest;
import io.u2ware.ocpp.v2_1.model.NotifyChargingLimitResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyChargingLimitOffer { 

    public NotifyChargingLimitRequest sendNotifyChargingLimitRequest(String id, Map<String,Object> req);

    public void receivedNotifyChargingLimitResponse(String id, NotifyChargingLimitResponse res, ErrorCode err);

}