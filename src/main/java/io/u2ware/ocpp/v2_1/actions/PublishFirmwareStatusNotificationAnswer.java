package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.PublishFirmwareStatusNotificationRequest;
import io.u2ware.ocpp.v2_1.model.PublishFirmwareStatusNotificationResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface PublishFirmwareStatusNotificationAnswer { 

    public PublishFirmwareStatusNotificationResponse receivedPublishFirmwareStatusNotificationRequest(String id, PublishFirmwareStatusNotificationRequest req);

    public void sendPublishFirmwareStatusNotificationResponse(String id, PublishFirmwareStatusNotificationResponse res, ErrorCode err);

}