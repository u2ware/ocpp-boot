package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.BootNotificationRequest;
import io.u2ware.ocpp.v2_1.model.BootNotificationResponse;

public interface BootNotificationOffer { 

    public BootNotificationRequest sendBootNotificationRequest(String id, Map<String,Object> req);

    public void receivedBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err);

}