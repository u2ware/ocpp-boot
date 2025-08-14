package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.SecurityEventNotificationOffer;
import io.u2ware.ocpp.v2_1.actions.SecurityEventNotificationAnswer;
import io.u2ware.ocpp.v2_1.model.SecurityEventNotificationRequest;
import io.u2ware.ocpp.v2_1.model.SecurityEventNotificationResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SecurityEventNotification {

    public interface ChargingStationHandler extends SecurityEventNotificationOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SecurityEventNotificationRequest sendSecurityEventNotificationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendSecurityEventNotificationRequest(%s)\n", id));
                return SecurityEventNotificationRequest.builder().build();
            }

            public void receivedSecurityEventNotificationResponse(String id, SecurityEventNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedSecurityEventNotificationResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends SecurityEventNotificationAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SecurityEventNotificationResponse receivedSecurityEventNotificationRequest(String id, SecurityEventNotificationRequest req){
                logger.info(String.format("\n\n\treceivedSecurityEventNotificationRequest(%s)\n", id));
                return SecurityEventNotificationResponse.builder().build();
            }

            public void sendSecurityEventNotificationResponse(String id, SecurityEventNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendSecurityEventNotificationResponse(%s)\n", id), err);
            }
        };
    }
}