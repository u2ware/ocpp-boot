package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.ClearCacheRequest;
import io.u2ware.ocpp.v1_6.model.ClearCacheResponse;

public interface ClearCacheAnswer { 

    public ClearCacheResponse receivedClearCacheRequest(String id, ClearCacheRequest req);

    public void sendClearCacheResponse(String id, ClearCacheResponse res, ErrorCode err);

}