package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.VatNumberValidationRequest;
import io.u2ware.ocpp.v2_1.model.VatNumberValidationResponse;

public interface VatNumberValidationAnswer { 

    public VatNumberValidationResponse receivedVatNumberValidationRequest(String id, VatNumberValidationRequest req);

    public void sendVatNumberValidationResponse(String id, VatNumberValidationResponse res, ErrorCode err);

}