package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.UpdateFirmwareOffer;
import io.u2ware.ocpp.v2_1.actions.UpdateFirmwareAnswer;
import io.u2ware.ocpp.v2_1.model.UpdateFirmwareRequest;
import io.u2ware.ocpp.v2_1.model.UpdateFirmwareResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface UpdateFirmware {

    public interface CSMSHandler extends UpdateFirmwareOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"UpdateFirmware"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public UpdateFirmwareRequest sendUpdateFirmwareRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendUpdateFirmwareRequest(%s)\n", id));
                return UpdateFirmwareRequest.builder().build();
            }

            public void receivedUpdateFirmwareResponse(String id, UpdateFirmwareResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedUpdateFirmwareResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends UpdateFirmwareAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"UpdateFirmware"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public UpdateFirmwareResponse receivedUpdateFirmwareRequest(String id, UpdateFirmwareRequest req){
                logger.info(String.format("\n\n\treceivedUpdateFirmwareRequest(%s)\n", id));
                return UpdateFirmwareResponse.builder().build();
            }

            public void sendUpdateFirmwareResponse(String id, UpdateFirmwareResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendUpdateFirmwareResponse(%s)\n", id), err);
            }
        };
    }
}