package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.SecurityEventNotificationRequest;
import io.u2ware.ocpp.v2_1.model.SecurityEventNotificationResponse;

public interface SecurityEventNotificationOffer { 

    public SecurityEventNotificationRequest sendSecurityEventNotificationRequest(String id, Map<String,Object> req);

    public void receivedSecurityEventNotificationResponse(String id, SecurityEventNotificationResponse res, ErrorCode err);

}