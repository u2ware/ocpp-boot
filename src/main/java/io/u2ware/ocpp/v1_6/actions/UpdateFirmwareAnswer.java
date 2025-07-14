package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.UpdateFirmwareRequest;
import io.u2ware.ocpp.v1_6.model.UpdateFirmwareResponse;

public interface UpdateFirmwareAnswer { 

    public UpdateFirmwareResponse receivedUpdateFirmwareRequest(String id, UpdateFirmwareRequest req);

    public void sendUpdateFirmwareResponse(String id, UpdateFirmwareResponse res, ErrorCode err);

}