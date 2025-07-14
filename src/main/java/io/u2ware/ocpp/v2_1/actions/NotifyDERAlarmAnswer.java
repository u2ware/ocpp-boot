package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyDERAlarmRequest;
import io.u2ware.ocpp.v2_1.model.NotifyDERAlarmResponse;

public interface NotifyDERAlarmAnswer { 

    public NotifyDERAlarmResponse receivedNotifyDERAlarmRequest(String id, NotifyDERAlarmRequest req);

    public void sendNotifyDERAlarmResponse(String id, NotifyDERAlarmResponse res, ErrorCode err);

}