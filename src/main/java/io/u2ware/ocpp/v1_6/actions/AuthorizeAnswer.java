package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.AuthorizeRequest;
import io.u2ware.ocpp.v1_6.model.AuthorizeResponse;

public interface AuthorizeAnswer { 

    public AuthorizeResponse receivedAuthorizeRequest(String id, AuthorizeRequest req);

    public void sendAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err);

}