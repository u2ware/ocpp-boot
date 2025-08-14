package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.GetMonitoringReportOffer;
import io.u2ware.ocpp.v2_0_1.actions.GetMonitoringReportAnswer;
import io.u2ware.ocpp.v2_0_1.model.GetMonitoringReportRequest;
import io.u2ware.ocpp.v2_0_1.model.GetMonitoringReportResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface GetMonitoringReport {

    public interface CSMSHandler extends GetMonitoringReportOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetMonitoringReportRequest sendGetMonitoringReportRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetMonitoringReportRequest(%s)\n", id));
                return GetMonitoringReportRequest.builder().build();
            }

            public void receivedGetMonitoringReportResponse(String id, GetMonitoringReportResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetMonitoringReportResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends GetMonitoringReportAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetMonitoringReportResponse receivedGetMonitoringReportRequest(String id, GetMonitoringReportRequest req){
                logger.info(String.format("\n\n\treceivedGetMonitoringReportRequest(%s)\n", id));
                return GetMonitoringReportResponse.builder().build();
            }

            public void sendGetMonitoringReportResponse(String id, GetMonitoringReportResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetMonitoringReportResponse(%s)\n", id), err);
            }
        };
    }
}