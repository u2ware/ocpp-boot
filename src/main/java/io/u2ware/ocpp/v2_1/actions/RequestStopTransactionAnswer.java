package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.RequestStopTransactionRequest;
import io.u2ware.ocpp.v2_1.model.RequestStopTransactionResponse;

public interface RequestStopTransactionAnswer { 

    public RequestStopTransactionResponse receivedRequestStopTransactionRequest(String id, RequestStopTransactionRequest req);

    public void sendRequestStopTransactionResponse(String id, RequestStopTransactionResponse res, ErrorCode err);

}