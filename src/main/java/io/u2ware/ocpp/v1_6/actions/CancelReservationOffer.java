package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.CancelReservationRequest;
import io.u2ware.ocpp.v1_6.model.CancelReservationResponse;

public interface CancelReservationOffer { 

    public CancelReservationRequest sendCancelReservationRequest(String id, Map<String,Object> req);

    public void receivedCancelReservationResponse(String id, CancelReservationResponse res, ErrorCode err);

}