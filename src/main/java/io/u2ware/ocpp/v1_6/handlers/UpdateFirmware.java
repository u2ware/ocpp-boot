package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.UpdateFirmwareOffer;
import io.u2ware.ocpp.v1_6.actions.UpdateFirmwareAnswer;
import io.u2ware.ocpp.v1_6.model.UpdateFirmwareRequest;
import io.u2ware.ocpp.v1_6.model.UpdateFirmwareResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface UpdateFirmware {

    public interface CentralSystemHandler extends UpdateFirmwareOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

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

    public interface ChargePointHandler extends UpdateFirmwareAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

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