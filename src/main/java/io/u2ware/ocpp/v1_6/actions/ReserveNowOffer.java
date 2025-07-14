package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.ReserveNowRequest;
import io.u2ware.ocpp.v1_6.model.ReserveNowResponse;

public interface ReserveNowOffer { 

    public ReserveNowRequest sendReserveNowRequest(String id, Map<String,Object> req);

    public void receivedReserveNowResponse(String id, ReserveNowResponse res, ErrorCode err);

}