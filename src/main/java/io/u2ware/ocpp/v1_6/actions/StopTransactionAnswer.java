package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.StopTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StopTransactionResponse;

public interface StopTransactionAnswer { 

    public StopTransactionResponse receivedStopTransactionRequest(String id, StopTransactionRequest req);

    public void sendStopTransactionResponse(String id, StopTransactionResponse res, ErrorCode err);

}