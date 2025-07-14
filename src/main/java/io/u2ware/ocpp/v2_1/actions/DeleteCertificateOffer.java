package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.DeleteCertificateRequest;
import io.u2ware.ocpp.v2_1.model.DeleteCertificateResponse;

public interface DeleteCertificateOffer { 

    public DeleteCertificateRequest sendDeleteCertificateRequest(String id, Map<String,Object> req);

    public void receivedDeleteCertificateResponse(String id, DeleteCertificateResponse res, ErrorCode err);

}