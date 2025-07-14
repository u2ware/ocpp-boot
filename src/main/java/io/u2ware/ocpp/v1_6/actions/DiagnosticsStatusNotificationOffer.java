package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.DiagnosticsStatusNotificationRequest;
import io.u2ware.ocpp.v1_6.model.DiagnosticsStatusNotificationResponse;

public interface DiagnosticsStatusNotificationOffer { 

    public DiagnosticsStatusNotificationRequest sendDiagnosticsStatusNotificationRequest(String id, Map<String,Object> req);

    public void receivedDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res, ErrorCode err);

}