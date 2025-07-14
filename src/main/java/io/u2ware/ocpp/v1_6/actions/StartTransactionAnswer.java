package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.StartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StartTransactionResponse;

public interface StartTransactionAnswer { 

    public StartTransactionResponse receivedStartTransactionRequest(String id, StartTransactionRequest req);

    public void sendStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err);

}