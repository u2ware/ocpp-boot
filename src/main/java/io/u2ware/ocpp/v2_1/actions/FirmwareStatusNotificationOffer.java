package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.FirmwareStatusNotificationRequest;
import io.u2ware.ocpp.v2_1.model.FirmwareStatusNotificationResponse;

public interface FirmwareStatusNotificationOffer { 

    public FirmwareStatusNotificationRequest sendFirmwareStatusNotificationRequest(String id, Map<String,Object> req);

    public void receivedFirmwareStatusNotificationResponse(String id, FirmwareStatusNotificationResponse res, ErrorCode err);

}