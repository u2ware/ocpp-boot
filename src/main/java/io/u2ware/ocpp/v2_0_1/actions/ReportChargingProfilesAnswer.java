package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.ReportChargingProfilesRequest;
import io.u2ware.ocpp.v2_0_1.model.ReportChargingProfilesResponse;

public interface ReportChargingProfilesAnswer { 

    public ReportChargingProfilesResponse receivedReportChargingProfilesRequest(String id, ReportChargingProfilesRequest req);

    public void sendReportChargingProfilesResponse(String id, ReportChargingProfilesResponse res, ErrorCode err);

}