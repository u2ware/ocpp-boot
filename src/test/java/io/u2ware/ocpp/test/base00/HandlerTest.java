package io.u2ware.ocpp.test.base00;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.AuthorizeRequest;
import io.u2ware.ocpp.v1_6.model.AuthorizeResponse;
import io.u2ware.ocpp.v1_6.model.BootNotificationRequest;
import io.u2ware.ocpp.v1_6.model.BootNotificationResponse;

public class HandlerTest implements HandlerA.ChargePointHandler, HandlerB.ChargePointHandler{


    @Override
    public AuthorizeRequest sendAuthorizeRequest(String id, Map<String, Object> req) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendAuthorizeRequest'");
    }

    @Override
    public void receivedAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receivedAuthorizeResponse'");
    }

    @Override
    public BootNotificationRequest sendBootNotificationRequest(String id, Map<String, Object> req) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sendBootNotificationRequest'");
    }

    @Override
    public void receivedBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receivedBootNotificationResponse'");
    }

}
