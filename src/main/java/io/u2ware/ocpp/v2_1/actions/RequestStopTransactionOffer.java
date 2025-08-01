package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.RequestStopTransactionRequest;
import io.u2ware.ocpp.v2_1.model.RequestStopTransactionResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface RequestStopTransactionOffer { 

    public RequestStopTransactionRequest sendRequestStopTransactionRequest(String id, Map<String,Object> req);

    public void receivedRequestStopTransactionResponse(String id, RequestStopTransactionResponse res, ErrorCode err);

}