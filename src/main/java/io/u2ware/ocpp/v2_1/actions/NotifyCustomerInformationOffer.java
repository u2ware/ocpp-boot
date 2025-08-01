package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.NotifyCustomerInformationRequest;
import io.u2ware.ocpp.v2_1.model.NotifyCustomerInformationResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyCustomerInformationOffer { 

    public NotifyCustomerInformationRequest sendNotifyCustomerInformationRequest(String id, Map<String,Object> req);

    public void receivedNotifyCustomerInformationResponse(String id, NotifyCustomerInformationResponse res, ErrorCode err);

}