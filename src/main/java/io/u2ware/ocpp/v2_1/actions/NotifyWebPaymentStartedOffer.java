package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.NotifyWebPaymentStartedRequest;
import io.u2ware.ocpp.v2_1.model.NotifyWebPaymentStartedResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyWebPaymentStartedOffer { 

    public NotifyWebPaymentStartedRequest sendNotifyWebPaymentStartedRequest(String id, Map<String,Object> req);

    public void receivedNotifyWebPaymentStartedResponse(String id, NotifyWebPaymentStartedResponse res, ErrorCode err);

}