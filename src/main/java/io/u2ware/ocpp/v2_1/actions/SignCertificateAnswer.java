package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.SignCertificateRequest;
import io.u2ware.ocpp.v2_1.model.SignCertificateResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SignCertificateAnswer { 

    public SignCertificateResponse receivedSignCertificateRequest(String id, SignCertificateRequest req);

    public void sendSignCertificateResponse(String id, SignCertificateResponse res, ErrorCode err);

}