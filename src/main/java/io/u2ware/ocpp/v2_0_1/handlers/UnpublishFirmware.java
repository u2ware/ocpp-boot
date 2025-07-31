package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.UnpublishFirmwareOffer;
import io.u2ware.ocpp.v2_0_1.actions.UnpublishFirmwareAnswer;
import io.u2ware.ocpp.v2_0_1.model.UnpublishFirmwareRequest;
import io.u2ware.ocpp.v2_0_1.model.UnpublishFirmwareResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface UnpublishFirmware {

    public interface CSMSHandler extends UnpublishFirmwareOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"UnpublishFirmware"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public UnpublishFirmwareRequest sendUnpublishFirmwareRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendUnpublishFirmwareRequest(%s)\n", id));
                return UnpublishFirmwareRequest.builder().build();
            }

            public void receivedUnpublishFirmwareResponse(String id, UnpublishFirmwareResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedUnpublishFirmwareResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends UnpublishFirmwareAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"UnpublishFirmware"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public UnpublishFirmwareResponse receivedUnpublishFirmwareRequest(String id, UnpublishFirmwareRequest req){
                logger.info(String.format("\n\n\treceivedUnpublishFirmwareRequest(%s)\n", id));
                return UnpublishFirmwareResponse.builder().build();
            }

            public void sendUnpublishFirmwareResponse(String id, UnpublishFirmwareResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendUnpublishFirmwareResponse(%s)\n", id), err);
            }
        };
    }
}