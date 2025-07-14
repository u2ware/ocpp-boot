package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.ResetRequest;
import io.u2ware.ocpp.v2_0_1.model.ResetResponse;

public interface ResetAnswer { 

    public ResetResponse receivedResetRequest(String id, ResetRequest req);

    public void sendResetResponse(String id, ResetResponse res, ErrorCode err);

}