package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.StartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StartTransactionResponse;

public interface StartTransactionOffer { 

    public StartTransactionRequest sendStartTransactionRequest(String id, Map<String,Object> req);

    public void receivedStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err);

}