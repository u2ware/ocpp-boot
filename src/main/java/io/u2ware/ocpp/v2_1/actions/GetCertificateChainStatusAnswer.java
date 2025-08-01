package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.GetCertificateChainStatusRequest;
import io.u2ware.ocpp.v2_1.model.GetCertificateChainStatusResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetCertificateChainStatusAnswer { 

    public GetCertificateChainStatusResponse receivedGetCertificateChainStatusRequest(String id, GetCertificateChainStatusRequest req);

    public void sendGetCertificateChainStatusResponse(String id, GetCertificateChainStatusResponse res, ErrorCode err);

}