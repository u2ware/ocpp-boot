package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyCustomerInformationRequest;
import io.u2ware.ocpp.v2_1.model.NotifyCustomerInformationResponse;

public interface NotifyCustomerInformationAnswer { 

    public NotifyCustomerInformationResponse receivedNotifyCustomerInformationRequest(String id, NotifyCustomerInformationRequest req);

    public void sendNotifyCustomerInformationResponse(String id, NotifyCustomerInformationResponse res, ErrorCode err);

}