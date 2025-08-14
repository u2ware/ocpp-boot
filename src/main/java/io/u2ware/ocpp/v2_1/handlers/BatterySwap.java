package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.BatterySwapOffer;
import io.u2ware.ocpp.v2_1.actions.BatterySwapAnswer;
import io.u2ware.ocpp.v2_1.model.BatterySwapRequest;
import io.u2ware.ocpp.v2_1.model.BatterySwapResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface BatterySwap {

    public interface ChargingStationHandler extends BatterySwapOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public BatterySwapRequest sendBatterySwapRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendBatterySwapRequest(%s)\n", id));
                return BatterySwapRequest.builder().build();
            }

            public void receivedBatterySwapResponse(String id, BatterySwapResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedBatterySwapResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends BatterySwapAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public BatterySwapResponse receivedBatterySwapRequest(String id, BatterySwapRequest req){
                logger.info(String.format("\n\n\treceivedBatterySwapRequest(%s)\n", id));
                return BatterySwapResponse.builder().build();
            }

            public void sendBatterySwapResponse(String id, BatterySwapResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendBatterySwapResponse(%s)\n", id), err);
            }
        };
    }
}