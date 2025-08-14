package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetReportOffer;
import io.u2ware.ocpp.v2_1.actions.GetReportAnswer;
import io.u2ware.ocpp.v2_1.model.GetReportRequest;
import io.u2ware.ocpp.v2_1.model.GetReportResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetReport {

    public interface ChargingStationHandler extends GetReportOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetReportRequest sendGetReportRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetReportRequest(%s)\n", id));
                return GetReportRequest.builder().build();
            }

            public void receivedGetReportResponse(String id, GetReportResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetReportResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends GetReportAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetReportResponse receivedGetReportRequest(String id, GetReportRequest req){
                logger.info(String.format("\n\n\treceivedGetReportRequest(%s)\n", id));
                return GetReportResponse.builder().build();
            }

            public void sendGetReportResponse(String id, GetReportResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetReportResponse(%s)\n", id), err);
            }
        };
    }
}