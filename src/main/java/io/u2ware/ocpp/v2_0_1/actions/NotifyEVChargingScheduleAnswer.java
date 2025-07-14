package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.NotifyEVChargingScheduleRequest;
import io.u2ware.ocpp.v2_0_1.model.NotifyEVChargingScheduleResponse;

public interface NotifyEVChargingScheduleAnswer { 

    public NotifyEVChargingScheduleResponse receivedNotifyEVChargingScheduleRequest(String id, NotifyEVChargingScheduleRequest req);

    public void sendNotifyEVChargingScheduleResponse(String id, NotifyEVChargingScheduleResponse res, ErrorCode err);

}