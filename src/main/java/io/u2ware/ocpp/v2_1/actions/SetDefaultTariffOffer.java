package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.SetDefaultTariffRequest;
import io.u2ware.ocpp.v2_1.model.SetDefaultTariffResponse;

public interface SetDefaultTariffOffer { 

    public SetDefaultTariffRequest sendSetDefaultTariffRequest(String id, Map<String,Object> req);

    public void receivedSetDefaultTariffResponse(String id, SetDefaultTariffResponse res, ErrorCode err);

}