package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ChangeTransactionTariffRequest;
import io.u2ware.ocpp.v2_1.model.ChangeTransactionTariffResponse;

public interface ChangeTransactionTariffAnswer { 

    public ChangeTransactionTariffResponse receivedChangeTransactionTariffRequest(String id, ChangeTransactionTariffRequest req);

    public void sendChangeTransactionTariffResponse(String id, ChangeTransactionTariffResponse res, ErrorCode err);

}