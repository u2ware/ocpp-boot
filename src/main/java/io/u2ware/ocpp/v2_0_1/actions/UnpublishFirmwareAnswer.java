package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.UnpublishFirmwareRequest;
import io.u2ware.ocpp.v2_0_1.model.UnpublishFirmwareResponse;

public interface UnpublishFirmwareAnswer { 

    public UnpublishFirmwareResponse receivedUnpublishFirmwareRequest(String id, UnpublishFirmwareRequest req);

    public void sendUnpublishFirmwareResponse(String id, UnpublishFirmwareResponse res, ErrorCode err);

}