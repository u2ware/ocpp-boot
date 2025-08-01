package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.DeleteCertificateRequest;
import io.u2ware.ocpp.v2_1.model.DeleteCertificateResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface DeleteCertificateAnswer { 

    public DeleteCertificateResponse receivedDeleteCertificateRequest(String id, DeleteCertificateRequest req);

    public void sendDeleteCertificateResponse(String id, DeleteCertificateResponse res, ErrorCode err);

}