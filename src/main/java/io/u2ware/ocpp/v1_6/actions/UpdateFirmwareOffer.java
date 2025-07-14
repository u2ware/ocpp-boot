package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.UpdateFirmwareRequest;
import io.u2ware.ocpp.v1_6.model.UpdateFirmwareResponse;

public interface UpdateFirmwareOffer { 

    public UpdateFirmwareRequest sendUpdateFirmwareRequest(String id, Map<String,Object> req);

    public void receivedUpdateFirmwareResponse(String id, UpdateFirmwareResponse res, ErrorCode err);

}