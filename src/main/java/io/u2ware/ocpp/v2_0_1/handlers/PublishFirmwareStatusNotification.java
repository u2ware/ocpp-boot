package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.PublishFirmwareStatusNotificationOffer;
import io.u2ware.ocpp.v2_0_1.actions.PublishFirmwareStatusNotificationAnswer;
import io.u2ware.ocpp.v2_0_1.model.PublishFirmwareStatusNotificationRequest;
import io.u2ware.ocpp.v2_0_1.model.PublishFirmwareStatusNotificationResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface PublishFirmwareStatusNotification {

    public interface ChargingStationHandler extends PublishFirmwareStatusNotificationOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"PublishFirmwareStatusNotification"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public PublishFirmwareStatusNotificationRequest sendPublishFirmwareStatusNotificationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendPublishFirmwareStatusNotificationRequest(%s)\n", id));
                return PublishFirmwareStatusNotificationRequest.builder().build();
            }

            public void receivedPublishFirmwareStatusNotificationResponse(String id, PublishFirmwareStatusNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedPublishFirmwareStatusNotificationResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends PublishFirmwareStatusNotificationAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"PublishFirmwareStatusNotification"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public PublishFirmwareStatusNotificationResponse receivedPublishFirmwareStatusNotificationRequest(String id, PublishFirmwareStatusNotificationRequest req){
                logger.info(String.format("\n\n\treceivedPublishFirmwareStatusNotificationRequest(%s)\n", id));
                return PublishFirmwareStatusNotificationResponse.builder().build();
            }

            public void sendPublishFirmwareStatusNotificationResponse(String id, PublishFirmwareStatusNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendPublishFirmwareStatusNotificationResponse(%s)\n", id), err);
            }
        };
    }
}