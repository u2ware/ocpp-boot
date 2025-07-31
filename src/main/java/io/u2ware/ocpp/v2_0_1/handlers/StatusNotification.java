package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.StatusNotificationOffer;
import io.u2ware.ocpp.v2_0_1.actions.StatusNotificationAnswer;
import io.u2ware.ocpp.v2_0_1.model.StatusNotificationRequest;
import io.u2ware.ocpp.v2_0_1.model.StatusNotificationResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface StatusNotification {

    public interface ChargingStationHandler extends StatusNotificationOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"StatusNotification"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public StatusNotificationRequest sendStatusNotificationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendStatusNotificationRequest(%s)\n", id));
                return StatusNotificationRequest.builder().build();
            }

            public void receivedStatusNotificationResponse(String id, StatusNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedStatusNotificationResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends StatusNotificationAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"StatusNotification"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public StatusNotificationResponse receivedStatusNotificationRequest(String id, StatusNotificationRequest req){
                logger.info(String.format("\n\n\treceivedStatusNotificationRequest(%s)\n", id));
                return StatusNotificationResponse.builder().build();
            }

            public void sendStatusNotificationResponse(String id, StatusNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendStatusNotificationResponse(%s)\n", id), err);
            }
        };
    }
}