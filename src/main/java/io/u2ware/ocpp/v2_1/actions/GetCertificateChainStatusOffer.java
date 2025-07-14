package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.GetCertificateChainStatusRequest;
import io.u2ware.ocpp.v2_1.model.GetCertificateChainStatusResponse;

public interface GetCertificateChainStatusOffer { 

    public GetCertificateChainStatusRequest sendGetCertificateChainStatusRequest(String id, Map<String,Object> req);

    public void receivedGetCertificateChainStatusResponse(String id, GetCertificateChainStatusResponse res, ErrorCode err);

}