package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.DataTransferRequest;
import io.u2ware.ocpp.v2_0_1.model.DataTransferResponse;

public interface DataTransferAnswer { 

    public DataTransferResponse receivedDataTransferRequest(String id, DataTransferRequest req);

    public void sendDataTransferResponse(String id, DataTransferResponse res, ErrorCode err);

}