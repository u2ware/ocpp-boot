package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.NotifyCustomerInformationRequest;
import io.u2ware.ocpp.v2_0_1.model.NotifyCustomerInformationResponse;

public interface NotifyCustomerInformationOffer { 

    public NotifyCustomerInformationRequest sendNotifyCustomerInformationRequest(String id, Map<String,Object> req);

    public void receivedNotifyCustomerInformationResponse(String id, NotifyCustomerInformationResponse res, ErrorCode err);

}