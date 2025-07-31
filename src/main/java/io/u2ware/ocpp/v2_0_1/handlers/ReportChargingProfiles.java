package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.ReportChargingProfilesOffer;
import io.u2ware.ocpp.v2_0_1.actions.ReportChargingProfilesAnswer;
import io.u2ware.ocpp.v2_0_1.model.ReportChargingProfilesRequest;
import io.u2ware.ocpp.v2_0_1.model.ReportChargingProfilesResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface ReportChargingProfiles {

    public interface ChargingStationHandler extends ReportChargingProfilesOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"ReportChargingProfiles"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ReportChargingProfilesRequest sendReportChargingProfilesRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendReportChargingProfilesRequest(%s)\n", id));
                return ReportChargingProfilesRequest.builder().build();
            }

            public void receivedReportChargingProfilesResponse(String id, ReportChargingProfilesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedReportChargingProfilesResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends ReportChargingProfilesAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"ReportChargingProfiles"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ReportChargingProfilesResponse receivedReportChargingProfilesRequest(String id, ReportChargingProfilesRequest req){
                logger.info(String.format("\n\n\treceivedReportChargingProfilesRequest(%s)\n", id));
                return ReportChargingProfilesResponse.builder().build();
            }

            public void sendReportChargingProfilesResponse(String id, ReportChargingProfilesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendReportChargingProfilesResponse(%s)\n", id), err);
            }
        };
    }
}