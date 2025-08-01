package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.ReportChargingProfilesRequest;
import io.u2ware.ocpp.v2_1.model.ReportChargingProfilesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ReportChargingProfilesAnswer { 

    public ReportChargingProfilesResponse receivedReportChargingProfilesRequest(String id, ReportChargingProfilesRequest req);

    public void sendReportChargingProfilesResponse(String id, ReportChargingProfilesResponse res, ErrorCode err);

}