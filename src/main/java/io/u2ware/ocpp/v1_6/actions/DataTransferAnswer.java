package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.DataTransferRequest;
import io.u2ware.ocpp.v1_6.model.DataTransferResponse;

public interface DataTransferAnswer { 

    public DataTransferResponse receivedDataTransferRequest(String id, DataTransferRequest req);

    public void sendDataTransferResponse(String id, DataTransferResponse res, ErrorCode err);

}