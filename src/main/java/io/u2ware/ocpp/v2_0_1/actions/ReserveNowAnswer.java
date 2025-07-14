package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.ReserveNowRequest;
import io.u2ware.ocpp.v2_0_1.model.ReserveNowResponse;

public interface ReserveNowAnswer { 

    public ReserveNowResponse receivedReserveNowRequest(String id, ReserveNowRequest req);

    public void sendReserveNowResponse(String id, ReserveNowResponse res, ErrorCode err);

}