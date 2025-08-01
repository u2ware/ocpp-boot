package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.InstallCertificateRequest;
import io.u2ware.ocpp.v2_1.model.InstallCertificateResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface InstallCertificateAnswer { 

    public InstallCertificateResponse receivedInstallCertificateRequest(String id, InstallCertificateRequest req);

    public void sendInstallCertificateResponse(String id, InstallCertificateResponse res, ErrorCode err);

}