package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.AuthorizeRequest;
import io.u2ware.ocpp.v2_0_1.model.AuthorizeResponse;

public interface AuthorizeAnswer { 

    public AuthorizeResponse receivedAuthorizeRequest(String id, AuthorizeRequest req);

    public void sendAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err);

}