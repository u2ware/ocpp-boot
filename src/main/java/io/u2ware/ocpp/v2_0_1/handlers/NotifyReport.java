package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.NotifyReportOffer;
import io.u2ware.ocpp.v2_0_1.actions.NotifyReportAnswer;
import io.u2ware.ocpp.v2_0_1.model.NotifyReportRequest;
import io.u2ware.ocpp.v2_0_1.model.NotifyReportResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface NotifyReport {

    public interface ChargingStationHandler extends NotifyReportOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"NotifyReport"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyReportRequest sendNotifyReportRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyReportRequest(%s)\n", id));
                return NotifyReportRequest.builder().build();
            }

            public void receivedNotifyReportResponse(String id, NotifyReportResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyReportResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifyReportAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"NotifyReport"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyReportResponse receivedNotifyReportRequest(String id, NotifyReportRequest req){
                logger.info(String.format("\n\n\treceivedNotifyReportRequest(%s)\n", id));
                return NotifyReportResponse.builder().build();
            }

            public void sendNotifyReportResponse(String id, NotifyReportResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyReportResponse(%s)\n", id), err);
            }
        };
    }
}