package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.LogStatusNotificationRequest;
import io.u2ware.ocpp.v2_0_1.model.LogStatusNotificationResponse;

public interface LogStatusNotificationAnswer { 

    public LogStatusNotificationResponse receivedLogStatusNotificationRequest(String id, LogStatusNotificationRequest req);

    public void sendLogStatusNotificationResponse(String id, LogStatusNotificationResponse res, ErrorCode err);

}