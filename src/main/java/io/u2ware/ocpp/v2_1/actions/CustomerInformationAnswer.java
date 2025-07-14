package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.CustomerInformationRequest;
import io.u2ware.ocpp.v2_1.model.CustomerInformationResponse;

public interface CustomerInformationAnswer { 

    public CustomerInformationResponse receivedCustomerInformationRequest(String id, CustomerInformationRequest req);

    public void sendCustomerInformationResponse(String id, CustomerInformationResponse res, ErrorCode err);

}