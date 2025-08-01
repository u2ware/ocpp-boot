package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.DataTransferRequest;
import io.u2ware.ocpp.v2_1.model.DataTransferResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface DataTransferOffer { 

    public DataTransferRequest sendDataTransferRequest(String id, Map<String,Object> req);

    public void receivedDataTransferResponse(String id, DataTransferResponse res, ErrorCode err);

}