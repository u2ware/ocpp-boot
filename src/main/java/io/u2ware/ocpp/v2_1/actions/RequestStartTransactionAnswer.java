package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.RequestStartTransactionRequest;
import io.u2ware.ocpp.v2_1.model.RequestStartTransactionResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface RequestStartTransactionAnswer { 

    public RequestStartTransactionResponse receivedRequestStartTransactionRequest(String id, RequestStartTransactionRequest req);

    public void sendRequestStartTransactionResponse(String id, RequestStartTransactionResponse res, ErrorCode err);

}