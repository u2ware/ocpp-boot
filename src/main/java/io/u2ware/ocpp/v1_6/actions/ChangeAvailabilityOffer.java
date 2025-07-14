package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.ChangeAvailabilityRequest;
import io.u2ware.ocpp.v1_6.model.ChangeAvailabilityResponse;

public interface ChangeAvailabilityOffer { 

    public ChangeAvailabilityRequest sendChangeAvailabilityRequest(String id, Map<String,Object> req);

    public void receivedChangeAvailabilityResponse(String id, ChangeAvailabilityResponse res, ErrorCode err);

}