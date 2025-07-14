package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionResponse;

public interface RemoteStartTransactionAnswer { 

    public RemoteStartTransactionResponse receivedRemoteStartTransactionRequest(String id, RemoteStartTransactionRequest req);

    public void sendRemoteStartTransactionResponse(String id, RemoteStartTransactionResponse res, ErrorCode err);

}