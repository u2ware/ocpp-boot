package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.TriggerMessageOffer;
import io.u2ware.ocpp.v2_0_1.actions.TriggerMessageAnswer;
import io.u2ware.ocpp.v2_0_1.model.TriggerMessageRequest;
import io.u2ware.ocpp.v2_0_1.model.TriggerMessageResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface TriggerMessage {

    public interface CSMSHandler extends TriggerMessageOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public TriggerMessageRequest sendTriggerMessageRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendTriggerMessageRequest(%s)\n", id));
                return TriggerMessageRequest.builder().build();
            }

            public void receivedTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedTriggerMessageResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends TriggerMessageAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public TriggerMessageResponse receivedTriggerMessageRequest(String id, TriggerMessageRequest req){
                logger.info(String.format("\n\n\treceivedTriggerMessageRequest(%s)\n", id));
                return TriggerMessageResponse.builder().build();
            }

            public void sendTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendTriggerMessageResponse(%s)\n", id), err);
            }
        };
    }
}