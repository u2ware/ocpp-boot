package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.CertificateSignedRequest;
import io.u2ware.ocpp.v2_1.model.CertificateSignedResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface CertificateSignedAnswer { 

    public CertificateSignedResponse receivedCertificateSignedRequest(String id, CertificateSignedRequest req);

    public void sendCertificateSignedResponse(String id, CertificateSignedResponse res, ErrorCode err);

}