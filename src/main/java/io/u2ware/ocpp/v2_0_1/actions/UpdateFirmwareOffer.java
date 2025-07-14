package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.UpdateFirmwareRequest;
import io.u2ware.ocpp.v2_0_1.model.UpdateFirmwareResponse;

public interface UpdateFirmwareOffer { 

    public UpdateFirmwareRequest sendUpdateFirmwareRequest(String id, Map<String,Object> req);

    public void receivedUpdateFirmwareResponse(String id, UpdateFirmwareResponse res, ErrorCode err);

}