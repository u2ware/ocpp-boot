package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.AuthorizeRequest;
import io.u2ware.ocpp.v2_1.model.AuthorizeResponse;

public interface AuthorizeOffer { 

    public AuthorizeRequest sendAuthorizeRequest(String id, Map<String,Object> req);

    public void receivedAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err);

}