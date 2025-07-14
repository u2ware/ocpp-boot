package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ResetRequest;
import io.u2ware.ocpp.v2_1.model.ResetResponse;

public interface ResetOffer { 

    public ResetRequest sendResetRequest(String id, Map<String,Object> req);

    public void receivedResetResponse(String id, ResetResponse res, ErrorCode err);

}