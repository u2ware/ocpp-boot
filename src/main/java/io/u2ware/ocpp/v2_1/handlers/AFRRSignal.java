package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.AFRRSignalOffer;
import io.u2ware.ocpp.v2_1.actions.AFRRSignalAnswer;
import io.u2ware.ocpp.v2_1.model.AFRRSignalRequest;
import io.u2ware.ocpp.v2_1.model.AFRRSignalResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface AFRRSignal {

    public interface CSMSHandler extends AFRRSignalOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public AFRRSignalRequest sendAFRRSignalRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendAFRRSignalRequest(%s)\n", id));
                return AFRRSignalRequest.builder().build();
            }

            public void receivedAFRRSignalResponse(String id, AFRRSignalResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedAFRRSignalResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends AFRRSignalAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public AFRRSignalResponse receivedAFRRSignalRequest(String id, AFRRSignalRequest req){
                logger.info(String.format("\n\n\treceivedAFRRSignalRequest(%s)\n", id));
                return AFRRSignalResponse.builder().build();
            }

            public void sendAFRRSignalResponse(String id, AFRRSignalResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendAFRRSignalResponse(%s)\n", id), err);
            }
        };
    }
}