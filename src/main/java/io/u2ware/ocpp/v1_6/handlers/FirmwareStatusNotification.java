package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.FirmwareStatusNotificationOffer;
import io.u2ware.ocpp.v1_6.actions.FirmwareStatusNotificationAnswer;
import io.u2ware.ocpp.v1_6.model.FirmwareStatusNotificationRequest;
import io.u2ware.ocpp.v1_6.model.FirmwareStatusNotificationResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface FirmwareStatusNotification {

    public interface ChargePointHandler extends FirmwareStatusNotificationOffer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {

        default String[] features() { return new String[]{"FirmwareStatusNotification"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public FirmwareStatusNotificationRequest sendFirmwareStatusNotificationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendFirmwareStatusNotificationRequest(%s)\n", id));
                return FirmwareStatusNotificationRequest.builder().build();
            }

            public void receivedFirmwareStatusNotificationResponse(String id, FirmwareStatusNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedFirmwareStatusNotificationResponse(%s)\n", id), err);
            }
        };
    }

    public interface CentralSystemHandler extends FirmwareStatusNotificationAnswer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {    

        default String[] features() { return new String[]{"FirmwareStatusNotification"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public FirmwareStatusNotificationResponse receivedFirmwareStatusNotificationRequest(String id, FirmwareStatusNotificationRequest req){
                logger.info(String.format("\n\n\treceivedFirmwareStatusNotificationRequest(%s)\n", id));
                return FirmwareStatusNotificationResponse.builder().build();
            }

            public void sendFirmwareStatusNotificationResponse(String id, FirmwareStatusNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendFirmwareStatusNotificationResponse(%s)\n", id), err);
            }
        };
    }
}