package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.GetTransactionStatusRequest;
import io.u2ware.ocpp.v2_0_1.model.GetTransactionStatusResponse;

public interface GetTransactionStatusOffer { 

    public GetTransactionStatusRequest sendGetTransactionStatusRequest(String id, Map<String,Object> req);

    public void receivedGetTransactionStatusResponse(String id, GetTransactionStatusResponse res, ErrorCode err);

}