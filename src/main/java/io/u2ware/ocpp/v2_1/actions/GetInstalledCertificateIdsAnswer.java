package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.GetInstalledCertificateIdsRequest;
import io.u2ware.ocpp.v2_1.model.GetInstalledCertificateIdsResponse;

public interface GetInstalledCertificateIdsAnswer { 

    public GetInstalledCertificateIdsResponse receivedGetInstalledCertificateIdsRequest(String id, GetInstalledCertificateIdsRequest req);

    public void sendGetInstalledCertificateIdsResponse(String id, GetInstalledCertificateIdsResponse res, ErrorCode err);

}