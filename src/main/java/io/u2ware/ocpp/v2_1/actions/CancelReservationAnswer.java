package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.CancelReservationRequest;
import io.u2ware.ocpp.v2_1.model.CancelReservationResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface CancelReservationAnswer { 

    public CancelReservationResponse receivedCancelReservationRequest(String id, CancelReservationRequest req);

    public void sendCancelReservationResponse(String id, CancelReservationResponse res, ErrorCode err);

}