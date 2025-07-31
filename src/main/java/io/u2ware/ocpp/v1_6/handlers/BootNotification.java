package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.BootNotificationOffer;
import io.u2ware.ocpp.v1_6.actions.BootNotificationAnswer;
import io.u2ware.ocpp.v1_6.model.BootNotificationRequest;
import io.u2ware.ocpp.v1_6.model.BootNotificationResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface BootNotification {

    public interface ChargePointHandler extends BootNotificationOffer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {

        default String[] features() { return new String[]{"BootNotification"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

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

    public interface CentralSystemHandler extends BootNotificationAnswer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {    

        default String[] features() { return new String[]{"BootNotification"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

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