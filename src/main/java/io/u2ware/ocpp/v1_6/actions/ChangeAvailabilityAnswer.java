package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.ChangeAvailabilityRequest;
import io.u2ware.ocpp.v1_6.model.ChangeAvailabilityResponse;

public interface ChangeAvailabilityAnswer { 

    public ChangeAvailabilityResponse receivedChangeAvailabilityRequest(String id, ChangeAvailabilityRequest req);

    public void sendChangeAvailabilityResponse(String id, ChangeAvailabilityResponse res, ErrorCode err);

}