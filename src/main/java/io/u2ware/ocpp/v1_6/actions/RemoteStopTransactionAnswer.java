package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.RemoteStopTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStopTransactionResponse;

public interface RemoteStopTransactionAnswer { 

    public RemoteStopTransactionResponse receivedRemoteStopTransactionRequest(String id, RemoteStopTransactionRequest req);

    public void sendRemoteStopTransactionResponse(String id, RemoteStopTransactionResponse res, ErrorCode err);

}