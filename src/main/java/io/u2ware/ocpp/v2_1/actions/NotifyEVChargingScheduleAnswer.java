package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.NotifyEVChargingScheduleRequest;
import io.u2ware.ocpp.v2_1.model.NotifyEVChargingScheduleResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyEVChargingScheduleAnswer { 

    public NotifyEVChargingScheduleResponse receivedNotifyEVChargingScheduleRequest(String id, NotifyEVChargingScheduleRequest req);

    public void sendNotifyEVChargingScheduleResponse(String id, NotifyEVChargingScheduleResponse res, ErrorCode err);

}