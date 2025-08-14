package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.FirmwareStatusNotificationOffer;
import io.u2ware.ocpp.v2_0_1.actions.FirmwareStatusNotificationAnswer;
import io.u2ware.ocpp.v2_0_1.model.FirmwareStatusNotificationRequest;
import io.u2ware.ocpp.v2_0_1.model.FirmwareStatusNotificationResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface FirmwareStatusNotification {

    public interface ChargingStationHandler extends FirmwareStatusNotificationOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

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

    public interface CSMSHandler extends FirmwareStatusNotificationAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

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