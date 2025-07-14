package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.UnpublishFirmwareRequest;
import io.u2ware.ocpp.v2_0_1.model.UnpublishFirmwareResponse;

public interface UnpublishFirmwareOffer { 

    public UnpublishFirmwareRequest sendUnpublishFirmwareRequest(String id, Map<String,Object> req);

    public void receivedUnpublishFirmwareResponse(String id, UnpublishFirmwareResponse res, ErrorCode err);

}