package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.NotifyEVChargingScheduleRequest;
import io.u2ware.ocpp.v2_0_1.model.NotifyEVChargingScheduleResponse;

public interface NotifyEVChargingScheduleOffer { 

    public NotifyEVChargingScheduleRequest sendNotifyEVChargingScheduleRequest(String id, Map<String,Object> req);

    public void receivedNotifyEVChargingScheduleResponse(String id, NotifyEVChargingScheduleResponse res, ErrorCode err);

}