package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.GetBaseReportOffer;
import io.u2ware.ocpp.v2_0_1.actions.GetBaseReportAnswer;
import io.u2ware.ocpp.v2_0_1.model.GetBaseReportRequest;
import io.u2ware.ocpp.v2_0_1.model.GetBaseReportResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface GetBaseReport {

    public interface CSMSHandler extends GetBaseReportOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"GetBaseReport"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetBaseReportRequest sendGetBaseReportRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetBaseReportRequest(%s)\n", id));
                return GetBaseReportRequest.builder().build();
            }

            public void receivedGetBaseReportResponse(String id, GetBaseReportResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetBaseReportResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends GetBaseReportAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"GetBaseReport"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetBaseReportResponse receivedGetBaseReportRequest(String id, GetBaseReportRequest req){
                logger.info(String.format("\n\n\treceivedGetBaseReportRequest(%s)\n", id));
                return GetBaseReportResponse.builder().build();
            }

            public void sendGetBaseReportResponse(String id, GetBaseReportResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetBaseReportResponse(%s)\n", id), err);
            }
        };
    }
}