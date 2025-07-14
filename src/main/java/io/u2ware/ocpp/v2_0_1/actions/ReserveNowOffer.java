package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.ReserveNowRequest;
import io.u2ware.ocpp.v2_0_1.model.ReserveNowResponse;

public interface ReserveNowOffer { 

    public ReserveNowRequest sendReserveNowRequest(String id, Map<String,Object> req);

    public void receivedReserveNowResponse(String id, ReserveNowResponse res, ErrorCode err);

}