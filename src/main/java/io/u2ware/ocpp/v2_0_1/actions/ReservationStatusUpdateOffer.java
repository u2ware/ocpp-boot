package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.ReservationStatusUpdateRequest;
import io.u2ware.ocpp.v2_0_1.model.ReservationStatusUpdateResponse;

public interface ReservationStatusUpdateOffer { 

    public ReservationStatusUpdateRequest sendReservationStatusUpdateRequest(String id, Map<String,Object> req);

    public void receivedReservationStatusUpdateResponse(String id, ReservationStatusUpdateResponse res, ErrorCode err);

}