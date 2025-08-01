package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.ReservationStatusUpdateRequest;
import io.u2ware.ocpp.v2_1.model.ReservationStatusUpdateResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ReservationStatusUpdateAnswer { 

    public ReservationStatusUpdateResponse receivedReservationStatusUpdateRequest(String id, ReservationStatusUpdateRequest req);

    public void sendReservationStatusUpdateResponse(String id, ReservationStatusUpdateResponse res, ErrorCode err);

}