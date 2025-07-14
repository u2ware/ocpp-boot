package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionResponse;

public interface RemoteStartTransactionOffer { 

    public RemoteStartTransactionRequest sendRemoteStartTransactionRequest(String id, Map<String,Object> req);

    public void receivedRemoteStartTransactionResponse(String id, RemoteStartTransactionResponse res, ErrorCode err);

}