package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.UsePriorityChargingOffer;
import io.u2ware.ocpp.v2_1.actions.UsePriorityChargingAnswer;
import io.u2ware.ocpp.v2_1.model.UsePriorityChargingRequest;
import io.u2ware.ocpp.v2_1.model.UsePriorityChargingResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface UsePriorityCharging {

    public interface CSMSHandler extends UsePriorityChargingOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public UsePriorityChargingRequest sendUsePriorityChargingRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendUsePriorityChargingRequest(%s)\n", id));
                return UsePriorityChargingRequest.builder().build();
            }

            public void receivedUsePriorityChargingResponse(String id, UsePriorityChargingResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedUsePriorityChargingResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends UsePriorityChargingAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public UsePriorityChargingResponse receivedUsePriorityChargingRequest(String id, UsePriorityChargingRequest req){
                logger.info(String.format("\n\n\treceivedUsePriorityChargingRequest(%s)\n", id));
                return UsePriorityChargingResponse.builder().build();
            }

            public void sendUsePriorityChargingResponse(String id, UsePriorityChargingResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendUsePriorityChargingResponse(%s)\n", id), err);
            }
        };
    }
}