package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.StatusNotificationRequest;
import io.u2ware.ocpp.v2_1.model.StatusNotificationResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface StatusNotificationOffer { 

    public StatusNotificationRequest sendStatusNotificationRequest(String id, Map<String,Object> req);

    public void receivedStatusNotificationResponse(String id, StatusNotificationResponse res, ErrorCode err);

}