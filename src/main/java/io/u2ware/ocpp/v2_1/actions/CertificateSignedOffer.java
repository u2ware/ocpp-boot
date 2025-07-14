package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.CertificateSignedRequest;
import io.u2ware.ocpp.v2_1.model.CertificateSignedResponse;

public interface CertificateSignedOffer { 

    public CertificateSignedRequest sendCertificateSignedRequest(String id, Map<String,Object> req);

    public void receivedCertificateSignedResponse(String id, CertificateSignedResponse res, ErrorCode err);

}