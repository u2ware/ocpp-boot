package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ClearCacheRequest;
import io.u2ware.ocpp.v2_1.model.ClearCacheResponse;

public interface ClearCacheAnswer { 

    public ClearCacheResponse receivedClearCacheRequest(String id, ClearCacheRequest req);

    public void sendClearCacheResponse(String id, ClearCacheResponse res, ErrorCode err);

}