package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.FirmwareStatusNotificationRequest;
import io.u2ware.ocpp.v2_0_1.model.FirmwareStatusNotificationResponse;

public interface FirmwareStatusNotificationAnswer { 

    public FirmwareStatusNotificationResponse receivedFirmwareStatusNotificationRequest(String id, FirmwareStatusNotificationRequest req);

    public void sendFirmwareStatusNotificationResponse(String id, FirmwareStatusNotificationResponse res, ErrorCode err);

}