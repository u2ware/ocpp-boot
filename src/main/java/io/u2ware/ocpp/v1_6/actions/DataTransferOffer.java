package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.DataTransferRequest;
import io.u2ware.ocpp.v1_6.model.DataTransferResponse;

public interface DataTransferOffer { 

    public DataTransferRequest sendDataTransferRequest(String id, Map<String,Object> req);

    public void receivedDataTransferResponse(String id, DataTransferResponse res, ErrorCode err);

}