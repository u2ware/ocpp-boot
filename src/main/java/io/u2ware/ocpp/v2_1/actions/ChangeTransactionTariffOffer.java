package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.ChangeTransactionTariffRequest;
import io.u2ware.ocpp.v2_1.model.ChangeTransactionTariffResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ChangeTransactionTariffOffer { 

    public ChangeTransactionTariffRequest sendChangeTransactionTariffRequest(String id, Map<String,Object> req);

    public void receivedChangeTransactionTariffResponse(String id, ChangeTransactionTariffResponse res, ErrorCode err);

}