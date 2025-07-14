package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.StopTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StopTransactionResponse;

public interface StopTransactionOffer { 

    public StopTransactionRequest sendStopTransactionRequest(String id, Map<String,Object> req);

    public void receivedStopTransactionResponse(String id, StopTransactionResponse res, ErrorCode err);

}