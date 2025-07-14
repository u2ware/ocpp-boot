package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.TransactionEventRequest;
import io.u2ware.ocpp.v2_0_1.model.TransactionEventResponse;

public interface TransactionEventOffer { 

    public TransactionEventRequest sendTransactionEventRequest(String id, Map<String,Object> req);

    public void receivedTransactionEventResponse(String id, TransactionEventResponse res, ErrorCode err);

}