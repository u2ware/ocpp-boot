package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.PublishFirmwareStatusNotificationRequest;
import io.u2ware.ocpp.v2_0_1.model.PublishFirmwareStatusNotificationResponse;

public interface PublishFirmwareStatusNotificationAnswer { 

    public PublishFirmwareStatusNotificationResponse receivedPublishFirmwareStatusNotificationRequest(String id, PublishFirmwareStatusNotificationRequest req);

    public void sendPublishFirmwareStatusNotificationResponse(String id, PublishFirmwareStatusNotificationResponse res, ErrorCode err);

}