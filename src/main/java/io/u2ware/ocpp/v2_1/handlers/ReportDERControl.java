package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.ReportDERControlOffer;
import io.u2ware.ocpp.v2_1.actions.ReportDERControlAnswer;
import io.u2ware.ocpp.v2_1.model.ReportDERControlRequest;
import io.u2ware.ocpp.v2_1.model.ReportDERControlResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ReportDERControl {

    public interface ChargingStationHandler extends ReportDERControlOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ReportDERControlRequest sendReportDERControlRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendReportDERControlRequest(%s)\n", id));
                return ReportDERControlRequest.builder().build();
            }

            public void receivedReportDERControlResponse(String id, ReportDERControlResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedReportDERControlResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends ReportDERControlAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ReportDERControlResponse receivedReportDERControlRequest(String id, ReportDERControlRequest req){
                logger.info(String.format("\n\n\treceivedReportDERControlRequest(%s)\n", id));
                return ReportDERControlResponse.builder().build();
            }

            public void sendReportDERControlResponse(String id, ReportDERControlResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendReportDERControlResponse(%s)\n", id), err);
            }
        };
    }
}