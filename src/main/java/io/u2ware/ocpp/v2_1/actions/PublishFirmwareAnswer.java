package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.PublishFirmwareRequest;
import io.u2ware.ocpp.v2_1.model.PublishFirmwareResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface PublishFirmwareAnswer { 

    public PublishFirmwareResponse receivedPublishFirmwareRequest(String id, PublishFirmwareRequest req);

    public void sendPublishFirmwareResponse(String id, PublishFirmwareResponse res, ErrorCode err);

}