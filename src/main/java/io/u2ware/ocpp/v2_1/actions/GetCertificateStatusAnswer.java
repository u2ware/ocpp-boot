package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.GetCertificateStatusRequest;
import io.u2ware.ocpp.v2_1.model.GetCertificateStatusResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetCertificateStatusAnswer { 

    public GetCertificateStatusResponse receivedGetCertificateStatusRequest(String id, GetCertificateStatusRequest req);

    public void sendGetCertificateStatusResponse(String id, GetCertificateStatusResponse res, ErrorCode err);

}