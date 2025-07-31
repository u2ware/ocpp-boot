package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.NotifyMonitoringReportOffer;
import io.u2ware.ocpp.v2_0_1.actions.NotifyMonitoringReportAnswer;
import io.u2ware.ocpp.v2_0_1.model.NotifyMonitoringReportRequest;
import io.u2ware.ocpp.v2_0_1.model.NotifyMonitoringReportResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface NotifyMonitoringReport {

    public interface ChargingStationHandler extends NotifyMonitoringReportOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"NotifyMonitoringReport"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyMonitoringReportRequest sendNotifyMonitoringReportRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyMonitoringReportRequest(%s)\n", id));
                return NotifyMonitoringReportRequest.builder().build();
            }

            public void receivedNotifyMonitoringReportResponse(String id, NotifyMonitoringReportResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyMonitoringReportResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifyMonitoringReportAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"NotifyMonitoringReport"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyMonitoringReportResponse receivedNotifyMonitoringReportRequest(String id, NotifyMonitoringReportRequest req){
                logger.info(String.format("\n\n\treceivedNotifyMonitoringReportRequest(%s)\n", id));
                return NotifyMonitoringReportResponse.builder().build();
            }

            public void sendNotifyMonitoringReportResponse(String id, NotifyMonitoringReportResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyMonitoringReportResponse(%s)\n", id), err);
            }
        };
    }
}