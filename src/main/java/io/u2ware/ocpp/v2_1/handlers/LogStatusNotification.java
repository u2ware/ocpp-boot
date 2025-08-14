package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.LogStatusNotificationOffer;
import io.u2ware.ocpp.v2_1.actions.LogStatusNotificationAnswer;
import io.u2ware.ocpp.v2_1.model.LogStatusNotificationRequest;
import io.u2ware.ocpp.v2_1.model.LogStatusNotificationResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface LogStatusNotification {

    public interface ChargingStationHandler extends LogStatusNotificationOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public LogStatusNotificationRequest sendLogStatusNotificationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendLogStatusNotificationRequest(%s)\n", id));
                return LogStatusNotificationRequest.builder().build();
            }

            public void receivedLogStatusNotificationResponse(String id, LogStatusNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedLogStatusNotificationResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends LogStatusNotificationAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public LogStatusNotificationResponse receivedLogStatusNotificationRequest(String id, LogStatusNotificationRequest req){
                logger.info(String.format("\n\n\treceivedLogStatusNotificationRequest(%s)\n", id));
                return LogStatusNotificationResponse.builder().build();
            }

            public void sendLogStatusNotificationResponse(String id, LogStatusNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendLogStatusNotificationResponse(%s)\n", id), err);
            }
        };
    }
}