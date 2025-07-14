package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.UpdateFirmwareRequest;
import io.u2ware.ocpp.v2_1.model.UpdateFirmwareResponse;

public interface UpdateFirmwareAnswer { 

    public UpdateFirmwareResponse receivedUpdateFirmwareRequest(String id, UpdateFirmwareRequest req);

    public void sendUpdateFirmwareResponse(String id, UpdateFirmwareResponse res, ErrorCode err);

}