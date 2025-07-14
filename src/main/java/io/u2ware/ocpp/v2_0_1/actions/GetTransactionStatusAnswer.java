package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.GetTransactionStatusRequest;
import io.u2ware.ocpp.v2_0_1.model.GetTransactionStatusResponse;

public interface GetTransactionStatusAnswer { 

    public GetTransactionStatusResponse receivedGetTransactionStatusRequest(String id, GetTransactionStatusRequest req);

    public void sendGetTransactionStatusResponse(String id, GetTransactionStatusResponse res, ErrorCode err);

}