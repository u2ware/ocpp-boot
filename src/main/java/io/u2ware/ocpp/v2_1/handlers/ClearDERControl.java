package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.ClearDERControlOffer;
import io.u2ware.ocpp.v2_1.actions.ClearDERControlAnswer;
import io.u2ware.ocpp.v2_1.model.ClearDERControlRequest;
import io.u2ware.ocpp.v2_1.model.ClearDERControlResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ClearDERControl {

    public interface CSMSHandler extends ClearDERControlOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearDERControlRequest sendClearDERControlRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendClearDERControlRequest(%s)\n", id));
                return ClearDERControlRequest.builder().build();
            }

            public void receivedClearDERControlResponse(String id, ClearDERControlResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedClearDERControlResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends ClearDERControlAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearDERControlResponse receivedClearDERControlRequest(String id, ClearDERControlRequest req){
                logger.info(String.format("\n\n\treceivedClearDERControlRequest(%s)\n", id));
                return ClearDERControlResponse.builder().build();
            }

            public void sendClearDERControlResponse(String id, ClearDERControlResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendClearDERControlResponse(%s)\n", id), err);
            }
        };
    }
}