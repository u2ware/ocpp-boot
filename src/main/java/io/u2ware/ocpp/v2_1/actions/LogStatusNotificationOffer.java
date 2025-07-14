package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.LogStatusNotificationRequest;
import io.u2ware.ocpp.v2_1.model.LogStatusNotificationResponse;

public interface LogStatusNotificationOffer { 

    public LogStatusNotificationRequest sendLogStatusNotificationRequest(String id, Map<String,Object> req);

    public void receivedLogStatusNotificationResponse(String id, LogStatusNotificationResponse res, ErrorCode err);

}