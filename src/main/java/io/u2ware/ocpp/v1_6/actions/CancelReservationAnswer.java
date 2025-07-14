package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.CancelReservationRequest;
import io.u2ware.ocpp.v1_6.model.CancelReservationResponse;

public interface CancelReservationAnswer { 

    public CancelReservationResponse receivedCancelReservationRequest(String id, CancelReservationRequest req);

    public void sendCancelReservationResponse(String id, CancelReservationResponse res, ErrorCode err);

}