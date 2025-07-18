package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ClearTariffsRequest;
import io.u2ware.ocpp.v2_1.model.ClearTariffsResponse;

public interface ClearTariffsAnswer { 

    public ClearTariffsResponse receivedClearTariffsRequest(String id, ClearTariffsRequest req);

    public void sendClearTariffsResponse(String id, ClearTariffsResponse res, ErrorCode err);

}