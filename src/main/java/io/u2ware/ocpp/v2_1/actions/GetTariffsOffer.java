package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.GetTariffsRequest;
import io.u2ware.ocpp.v2_1.model.GetTariffsResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetTariffsOffer { 

    public GetTariffsRequest sendGetTariffsRequest(String id, Map<String,Object> req);

    public void receivedGetTariffsResponse(String id, GetTariffsResponse res, ErrorCode err);

}