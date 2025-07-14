package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyWebPaymentStartedRequest;
import io.u2ware.ocpp.v2_1.model.NotifyWebPaymentStartedResponse;

public interface NotifyWebPaymentStartedAnswer { 

    public NotifyWebPaymentStartedResponse receivedNotifyWebPaymentStartedRequest(String id, NotifyWebPaymentStartedRequest req);

    public void sendNotifyWebPaymentStartedResponse(String id, NotifyWebPaymentStartedResponse res, ErrorCode err);

}