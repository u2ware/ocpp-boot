package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.PublishFirmwareOffer;
import io.u2ware.ocpp.v2_0_1.actions.PublishFirmwareAnswer;
import io.u2ware.ocpp.v2_0_1.model.PublishFirmwareRequest;
import io.u2ware.ocpp.v2_0_1.model.PublishFirmwareResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface PublishFirmware {

    public interface CSMSHandler extends PublishFirmwareOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"PublishFirmware"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public PublishFirmwareRequest sendPublishFirmwareRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendPublishFirmwareRequest(%s)\n", id));
                return PublishFirmwareRequest.builder().build();
            }

            public void receivedPublishFirmwareResponse(String id, PublishFirmwareResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedPublishFirmwareResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends PublishFirmwareAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"PublishFirmware"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public PublishFirmwareResponse receivedPublishFirmwareRequest(String id, PublishFirmwareRequest req){
                logger.info(String.format("\n\n\treceivedPublishFirmwareRequest(%s)\n", id));
                return PublishFirmwareResponse.builder().build();
            }

            public void sendPublishFirmwareResponse(String id, PublishFirmwareResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendPublishFirmwareResponse(%s)\n", id), err);
            }
        };
    }
}