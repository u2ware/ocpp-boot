package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.SecurityEventNotificationRequest;
import io.u2ware.ocpp.v2_0_1.model.SecurityEventNotificationResponse;

public interface SecurityEventNotificationAnswer { 

    public SecurityEventNotificationResponse receivedSecurityEventNotificationRequest(String id, SecurityEventNotificationRequest req);

    public void sendSecurityEventNotificationResponse(String id, SecurityEventNotificationResponse res, ErrorCode err);

}