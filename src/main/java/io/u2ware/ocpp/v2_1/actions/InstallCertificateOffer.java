package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.InstallCertificateRequest;
import io.u2ware.ocpp.v2_1.model.InstallCertificateResponse;

public interface InstallCertificateOffer { 

    public InstallCertificateRequest sendInstallCertificateRequest(String id, Map<String,Object> req);

    public void receivedInstallCertificateResponse(String id, InstallCertificateResponse res, ErrorCode err);

}