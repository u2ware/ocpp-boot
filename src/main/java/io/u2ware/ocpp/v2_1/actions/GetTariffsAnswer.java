package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.GetTariffsRequest;
import io.u2ware.ocpp.v2_1.model.GetTariffsResponse;

public interface GetTariffsAnswer { 

    public GetTariffsResponse receivedGetTariffsRequest(String id, GetTariffsRequest req);

    public void sendGetTariffsResponse(String id, GetTariffsResponse res, ErrorCode err);

}