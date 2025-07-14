package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.ResetRequest;
import io.u2ware.ocpp.v1_6.model.ResetResponse;

public interface ResetAnswer { 

    public ResetResponse receivedResetRequest(String id, ResetRequest req);

    public void sendResetResponse(String id, ResetResponse res, ErrorCode err);

}