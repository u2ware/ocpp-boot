package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.UnpublishFirmwareRequest;
import io.u2ware.ocpp.v2_1.model.UnpublishFirmwareResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface UnpublishFirmwareOffer { 

    public UnpublishFirmwareRequest sendUnpublishFirmwareRequest(String id, Map<String,Object> req);

    public void receivedUnpublishFirmwareResponse(String id, UnpublishFirmwareResponse res, ErrorCode err);

}