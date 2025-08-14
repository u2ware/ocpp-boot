package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.BootNotificationOffer;
import io.u2ware.ocpp.v2_1.actions.BootNotificationAnswer;
import io.u2ware.ocpp.v2_1.model.BootNotificationRequest;
import io.u2ware.ocpp.v2_1.model.BootNotificationResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface BootNotification {

    public interface ChargingStationHandler extends BootNotificationOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public BootNotificationRequest sendBootNotificationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendBootNotificationRequest(%s)\n", id));
                return BootNotificationRequest.builder().build();
            }

            public void receivedBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedBootNotificationResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends BootNotificationAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public BootNotificationResponse receivedBootNotificationRequest(String id, BootNotificationRequest req){
                logger.info(String.format("\n\n\treceivedBootNotificationRequest(%s)\n", id));
                return BootNotificationResponse.builder().build();
            }

            public void sendBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendBootNotificationResponse(%s)\n", id), err);
            }
        };
    }
}