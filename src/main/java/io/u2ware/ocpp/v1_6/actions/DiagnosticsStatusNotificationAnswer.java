package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.DiagnosticsStatusNotificationRequest;
import io.u2ware.ocpp.v1_6.model.DiagnosticsStatusNotificationResponse;

public interface DiagnosticsStatusNotificationAnswer { 

    public DiagnosticsStatusNotificationResponse receivedDiagnosticsStatusNotificationRequest(String id, DiagnosticsStatusNotificationRequest req);

    public void sendDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res, ErrorCode err);

}