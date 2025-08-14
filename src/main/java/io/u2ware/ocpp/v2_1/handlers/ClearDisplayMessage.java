package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.ClearDisplayMessageOffer;
import io.u2ware.ocpp.v2_1.actions.ClearDisplayMessageAnswer;
import io.u2ware.ocpp.v2_1.model.ClearDisplayMessageRequest;
import io.u2ware.ocpp.v2_1.model.ClearDisplayMessageResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ClearDisplayMessage {

    public interface ChargingStationHandler extends ClearDisplayMessageOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearDisplayMessageRequest sendClearDisplayMessageRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendClearDisplayMessageRequest(%s)\n", id));
                return ClearDisplayMessageRequest.builder().build();
            }

            public void receivedClearDisplayMessageResponse(String id, ClearDisplayMessageResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedClearDisplayMessageResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends ClearDisplayMessageAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearDisplayMessageResponse receivedClearDisplayMessageRequest(String id, ClearDisplayMessageRequest req){
                logger.info(String.format("\n\n\treceivedClearDisplayMessageRequest(%s)\n", id));
                return ClearDisplayMessageResponse.builder().build();
            }

            public void sendClearDisplayMessageResponse(String id, ClearDisplayMessageResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendClearDisplayMessageResponse(%s)\n", id), err);
            }
        };
    }
}