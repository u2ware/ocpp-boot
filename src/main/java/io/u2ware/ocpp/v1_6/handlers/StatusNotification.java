package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.StatusNotificationOffer;
import io.u2ware.ocpp.v1_6.actions.StatusNotificationAnswer;
import io.u2ware.ocpp.v1_6.model.StatusNotificationRequest;
import io.u2ware.ocpp.v1_6.model.StatusNotificationResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface StatusNotification {

    public interface ChargePointHandler extends StatusNotificationOffer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {

        default String[] features() { return new String[]{"StatusNotification"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

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

    public interface CentralSystemHandler extends StatusNotificationAnswer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {    

        default String[] features() { return new String[]{"StatusNotification"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

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