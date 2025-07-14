package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.FirmwareStatusNotificationRequest;
import io.u2ware.ocpp.v1_6.model.FirmwareStatusNotificationResponse;

public interface FirmwareStatusNotificationAnswer { 

    public FirmwareStatusNotificationResponse receivedFirmwareStatusNotificationRequest(String id, FirmwareStatusNotificationRequest req);

    public void sendFirmwareStatusNotificationResponse(String id, FirmwareStatusNotificationResponse res, ErrorCode err);

}