package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.ReserveNowRequest;
import io.u2ware.ocpp.v2_1.model.ReserveNowResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ReserveNowOffer { 

    public ReserveNowRequest sendReserveNowRequest(String id, Map<String,Object> req);

    public void receivedReserveNowResponse(String id, ReserveNowResponse res, ErrorCode err);

}