package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.StatusNotificationRequest;
import io.u2ware.ocpp.v2_1.model.StatusNotificationResponse;

public interface StatusNotificationAnswer { 

    public StatusNotificationResponse receivedStatusNotificationRequest(String id, StatusNotificationRequest req);

    public void sendStatusNotificationResponse(String id, StatusNotificationResponse res, ErrorCode err);

}