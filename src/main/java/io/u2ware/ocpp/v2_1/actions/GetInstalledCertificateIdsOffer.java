package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.GetInstalledCertificateIdsRequest;
import io.u2ware.ocpp.v2_1.model.GetInstalledCertificateIdsResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetInstalledCertificateIdsOffer { 

    public GetInstalledCertificateIdsRequest sendGetInstalledCertificateIdsRequest(String id, Map<String,Object> req);

    public void receivedGetInstalledCertificateIdsResponse(String id, GetInstalledCertificateIdsResponse res, ErrorCode err);

}