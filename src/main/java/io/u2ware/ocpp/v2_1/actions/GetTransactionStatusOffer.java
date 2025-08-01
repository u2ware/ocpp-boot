package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.GetTransactionStatusRequest;
import io.u2ware.ocpp.v2_1.model.GetTransactionStatusResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetTransactionStatusOffer { 

    public GetTransactionStatusRequest sendGetTransactionStatusRequest(String id, Map<String,Object> req);

    public void receivedGetTransactionStatusResponse(String id, GetTransactionStatusResponse res, ErrorCode err);

}