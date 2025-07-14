package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.RemoteStopTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStopTransactionResponse;

public interface RemoteStopTransactionOffer { 

    public RemoteStopTransactionRequest sendRemoteStopTransactionRequest(String id, Map<String,Object> req);

    public void receivedRemoteStopTransactionResponse(String id, RemoteStopTransactionResponse res, ErrorCode err);

}