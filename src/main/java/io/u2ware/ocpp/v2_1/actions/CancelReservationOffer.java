package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.CancelReservationRequest;
import io.u2ware.ocpp.v2_1.model.CancelReservationResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface CancelReservationOffer { 

    public CancelReservationRequest sendCancelReservationRequest(String id, Map<String,Object> req);

    public void receivedCancelReservationResponse(String id, CancelReservationResponse res, ErrorCode err);

}