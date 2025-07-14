package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.TransactionEventRequest;
import io.u2ware.ocpp.v2_0_1.model.TransactionEventResponse;

public interface TransactionEventAnswer { 

    public TransactionEventResponse receivedTransactionEventRequest(String id, TransactionEventRequest req);

    public void sendTransactionEventResponse(String id, TransactionEventResponse res, ErrorCode err);

}