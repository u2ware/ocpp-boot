package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.ReserveNowRequest;
import io.u2ware.ocpp.v1_6.model.ReserveNowResponse;

public interface ReserveNowAnswer { 

    public ReserveNowResponse receivedReserveNowRequest(String id, ReserveNowRequest req);

    public void sendReserveNowResponse(String id, ReserveNowResponse res, ErrorCode err);

}