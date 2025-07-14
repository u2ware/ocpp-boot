package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.RequestStartTransactionRequest;
import io.u2ware.ocpp.v2_1.model.RequestStartTransactionResponse;

public interface RequestStartTransactionOffer { 

    public RequestStartTransactionRequest sendRequestStartTransactionRequest(String id, Map<String,Object> req);

    public void receivedRequestStartTransactionResponse(String id, RequestStartTransactionResponse res, ErrorCode err);

}