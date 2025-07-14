package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.CustomerInformationRequest;
import io.u2ware.ocpp.v2_1.model.CustomerInformationResponse;

public interface CustomerInformationOffer { 

    public CustomerInformationRequest sendCustomerInformationRequest(String id, Map<String,Object> req);

    public void receivedCustomerInformationResponse(String id, CustomerInformationResponse res, ErrorCode err);

}