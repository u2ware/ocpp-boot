package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ChangeAvailabilityRequest;
import io.u2ware.ocpp.v2_1.model.ChangeAvailabilityResponse;

public interface ChangeAvailabilityAnswer { 

    public ChangeAvailabilityResponse receivedChangeAvailabilityRequest(String id, ChangeAvailabilityRequest req);

    public void sendChangeAvailabilityResponse(String id, ChangeAvailabilityResponse res, ErrorCode err);

}