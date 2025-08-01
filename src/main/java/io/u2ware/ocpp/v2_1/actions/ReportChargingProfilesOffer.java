package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.ReportChargingProfilesRequest;
import io.u2ware.ocpp.v2_1.model.ReportChargingProfilesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ReportChargingProfilesOffer { 

    public ReportChargingProfilesRequest sendReportChargingProfilesRequest(String id, Map<String,Object> req);

    public void receivedReportChargingProfilesResponse(String id, ReportChargingProfilesResponse res, ErrorCode err);

}