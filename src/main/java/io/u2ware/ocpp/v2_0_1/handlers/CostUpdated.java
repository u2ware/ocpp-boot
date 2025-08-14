package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.CostUpdatedOffer;
import io.u2ware.ocpp.v2_0_1.actions.CostUpdatedAnswer;
import io.u2ware.ocpp.v2_0_1.model.CostUpdatedRequest;
import io.u2ware.ocpp.v2_0_1.model.CostUpdatedResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface CostUpdated {

    public interface CSMSHandler extends CostUpdatedOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public CostUpdatedRequest sendCostUpdatedRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendCostUpdatedRequest(%s)\n", id));
                return CostUpdatedRequest.builder().build();
            }

            public void receivedCostUpdatedResponse(String id, CostUpdatedResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedCostUpdatedResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends CostUpdatedAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public CostUpdatedResponse receivedCostUpdatedRequest(String id, CostUpdatedRequest req){
                logger.info(String.format("\n\n\treceivedCostUpdatedRequest(%s)\n", id));
                return CostUpdatedResponse.builder().build();
            }

            public void sendCostUpdatedResponse(String id, CostUpdatedResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendCostUpdatedResponse(%s)\n", id), err);
            }
        };
    }
}