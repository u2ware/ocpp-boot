package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.BootNotificationRequest;
import io.u2ware.ocpp.v2_1.model.BootNotificationResponse;

public interface BootNotificationAnswer { 

    public BootNotificationResponse receivedBootNotificationRequest(String id, BootNotificationRequest req);

    public void sendBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err);

}