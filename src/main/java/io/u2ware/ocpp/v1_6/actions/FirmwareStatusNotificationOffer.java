package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.FirmwareStatusNotificationRequest;
import io.u2ware.ocpp.v1_6.model.FirmwareStatusNotificationResponse;

public interface FirmwareStatusNotificationOffer { 

    public FirmwareStatusNotificationRequest sendFirmwareStatusNotificationRequest(String id, Map<String,Object> req);

    public void receivedFirmwareStatusNotificationResponse(String id, FirmwareStatusNotificationResponse res, ErrorCode err);

}