package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.ClearCacheRequest;
import io.u2ware.ocpp.v2_1.model.ClearCacheResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ClearCacheOffer { 

    public ClearCacheRequest sendClearCacheRequest(String id, Map<String,Object> req);

    public void receivedClearCacheResponse(String id, ClearCacheResponse res, ErrorCode err);

}