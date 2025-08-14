package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.TriggerMessageOffer;
import io.u2ware.ocpp.v1_6.actions.TriggerMessageAnswer;
import io.u2ware.ocpp.v1_6.model.TriggerMessageRequest;
import io.u2ware.ocpp.v1_6.model.TriggerMessageResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface TriggerMessage {

    public interface CentralSystemHandler extends TriggerMessageOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

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

    public interface ChargePointHandler extends TriggerMessageAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

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