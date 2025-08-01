package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.SignCertificateRequest;
import io.u2ware.ocpp.v2_1.model.SignCertificateResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SignCertificateOffer { 

    public SignCertificateRequest sendSignCertificateRequest(String id, Map<String,Object> req);

    public void receivedSignCertificateResponse(String id, SignCertificateResponse res, ErrorCode err);

}