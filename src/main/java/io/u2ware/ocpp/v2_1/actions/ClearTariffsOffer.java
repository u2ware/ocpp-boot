package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.ClearTariffsRequest;
import io.u2ware.ocpp.v2_1.model.ClearTariffsResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ClearTariffsOffer { 

    public ClearTariffsRequest sendClearTariffsRequest(String id, Map<String,Object> req);

    public void receivedClearTariffsResponse(String id, ClearTariffsResponse res, ErrorCode err);

}