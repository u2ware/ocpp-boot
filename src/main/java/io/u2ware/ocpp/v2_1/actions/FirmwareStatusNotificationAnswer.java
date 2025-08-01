package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.FirmwareStatusNotificationRequest;
import io.u2ware.ocpp.v2_1.model.FirmwareStatusNotificationResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface FirmwareStatusNotificationAnswer { 

    public FirmwareStatusNotificationResponse receivedFirmwareStatusNotificationRequest(String id, FirmwareStatusNotificationRequest req);

    public void sendFirmwareStatusNotificationResponse(String id, FirmwareStatusNotificationResponse res, ErrorCode err);

}