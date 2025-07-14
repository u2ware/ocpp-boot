package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.StatusNotificationRequest;
import io.u2ware.ocpp.v1_6.model.StatusNotificationResponse;

public interface StatusNotificationAnswer { 

    public StatusNotificationResponse receivedStatusNotificationRequest(String id, StatusNotificationRequest req);

    public void sendStatusNotificationResponse(String id, StatusNotificationResponse res, ErrorCode err);

}