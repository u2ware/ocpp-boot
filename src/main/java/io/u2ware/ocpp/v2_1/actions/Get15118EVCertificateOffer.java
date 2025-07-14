package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.Get15118EVCertificateRequest;
import io.u2ware.ocpp.v2_1.model.Get15118EVCertificateResponse;

public interface Get15118EVCertificateOffer { 

    public Get15118EVCertificateRequest sendGet15118EVCertificateRequest(String id, Map<String,Object> req);

    public void receivedGet15118EVCertificateResponse(String id, Get15118EVCertificateResponse res, ErrorCode err);

}