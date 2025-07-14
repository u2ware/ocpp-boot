package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.PublishFirmwareRequest;
import io.u2ware.ocpp.v2_0_1.model.PublishFirmwareResponse;

public interface PublishFirmwareOffer { 

    public PublishFirmwareRequest sendPublishFirmwareRequest(String id, Map<String,Object> req);

    public void receivedPublishFirmwareResponse(String id, PublishFirmwareResponse res, ErrorCode err);

}