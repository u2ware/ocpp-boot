package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.ClearedChargingLimitOffer;
import io.u2ware.ocpp.v2_0_1.actions.ClearedChargingLimitAnswer;
import io.u2ware.ocpp.v2_0_1.model.ClearedChargingLimitRequest;
import io.u2ware.ocpp.v2_0_1.model.ClearedChargingLimitResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface ClearedChargingLimit {

    public interface ChargingStationHandler extends ClearedChargingLimitOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearedChargingLimitRequest sendClearedChargingLimitRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendClearedChargingLimitRequest(%s)\n", id));
                return ClearedChargingLimitRequest.builder().build();
            }

            public void receivedClearedChargingLimitResponse(String id, ClearedChargingLimitResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedClearedChargingLimitResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends ClearedChargingLimitAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearedChargingLimitResponse receivedClearedChargingLimitRequest(String id, ClearedChargingLimitRequest req){
                logger.info(String.format("\n\n\treceivedClearedChargingLimitRequest(%s)\n", id));
                return ClearedChargingLimitResponse.builder().build();
            }

            public void sendClearedChargingLimitResponse(String id, ClearedChargingLimitResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendClearedChargingLimitResponse(%s)\n", id), err);
            }
        };
    }
}