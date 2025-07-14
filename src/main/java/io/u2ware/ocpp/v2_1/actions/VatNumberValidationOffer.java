package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.VatNumberValidationRequest;
import io.u2ware.ocpp.v2_1.model.VatNumberValidationResponse;

public interface VatNumberValidationOffer { 

    public VatNumberValidationRequest sendVatNumberValidationRequest(String id, Map<String,Object> req);

    public void receivedVatNumberValidationResponse(String id, VatNumberValidationResponse res, ErrorCode err);

}