package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.Get15118EVCertificateRequest;
import io.u2ware.ocpp.v2_0_1.model.Get15118EVCertificateResponse;

public interface Get15118EVCertificateAnswer { 

    public Get15118EVCertificateResponse receivedGet15118EVCertificateRequest(String id, Get15118EVCertificateRequest req);

    public void sendGet15118EVCertificateResponse(String id, Get15118EVCertificateResponse res, ErrorCode err);

}