package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.SetDefaultTariffRequest;
import io.u2ware.ocpp.v2_1.model.SetDefaultTariffResponse;

public interface SetDefaultTariffAnswer { 

    public SetDefaultTariffResponse receivedSetDefaultTariffRequest(String id, SetDefaultTariffRequest req);

    public void sendSetDefaultTariffResponse(String id, SetDefaultTariffResponse res, ErrorCode err);

}