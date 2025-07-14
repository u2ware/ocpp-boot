package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.PublishFirmwareStatusNotificationRequest;
import io.u2ware.ocpp.v2_1.model.PublishFirmwareStatusNotificationResponse;

public interface PublishFirmwareStatusNotificationOffer { 

    public PublishFirmwareStatusNotificationRequest sendPublishFirmwareStatusNotificationRequest(String id, Map<String,Object> req);

    public void receivedPublishFirmwareStatusNotificationResponse(String id, PublishFirmwareStatusNotificationResponse res, ErrorCode err);

}