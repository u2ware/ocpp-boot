package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.BootNotificationRequest;
import io.u2ware.ocpp.v1_6.model.BootNotificationResponse;

public interface BootNotificationOffer { 

    public BootNotificationRequest sendBootNotificationRequest(String id, Map<String,Object> req);

    public void receivedBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err);

}