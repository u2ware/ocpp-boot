package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.NotifyDERAlarmRequest;
import io.u2ware.ocpp.v2_1.model.NotifyDERAlarmResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyDERAlarmOffer { 

    public NotifyDERAlarmRequest sendNotifyDERAlarmRequest(String id, Map<String,Object> req);

    public void receivedNotifyDERAlarmResponse(String id, NotifyDERAlarmResponse res, ErrorCode err);

}