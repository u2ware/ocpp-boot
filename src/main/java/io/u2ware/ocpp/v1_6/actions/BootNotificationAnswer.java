package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.BootNotificationRequest;
import io.u2ware.ocpp.v1_6.model.BootNotificationResponse;

public interface BootNotificationAnswer { 

    public BootNotificationResponse receivedBootNotificationRequest(String id, BootNotificationRequest req);

    public void sendBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err);

}