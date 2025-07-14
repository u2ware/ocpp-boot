package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ChangeAvailabilityRequest;
import io.u2ware.ocpp.v2_1.model.ChangeAvailabilityResponse;

public interface ChangeAvailabilityOffer { 

    public ChangeAvailabilityRequest sendChangeAvailabilityRequest(String id, Map<String,Object> req);

    public void receivedChangeAvailabilityResponse(String id, ChangeAvailabilityResponse res, ErrorCode err);

}