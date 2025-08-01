package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.GetCertificateStatusRequest;
import io.u2ware.ocpp.v2_1.model.GetCertificateStatusResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetCertificateStatusOffer { 

    public GetCertificateStatusRequest sendGetCertificateStatusRequest(String id, Map<String,Object> req);

    public void receivedGetCertificateStatusResponse(String id, GetCertificateStatusResponse res, ErrorCode err);

}