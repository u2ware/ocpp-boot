package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.SetDisplayMessageOffer;
import io.u2ware.ocpp.v2_0_1.actions.SetDisplayMessageAnswer;
import io.u2ware.ocpp.v2_0_1.model.SetDisplayMessageRequest;
import io.u2ware.ocpp.v2_0_1.model.SetDisplayMessageResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface SetDisplayMessage {

    public interface CSMSHandler extends SetDisplayMessageOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetDisplayMessageRequest sendSetDisplayMessageRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendSetDisplayMessageRequest(%s)\n", id));
                return SetDisplayMessageRequest.builder().build();
            }

            public void receivedSetDisplayMessageResponse(String id, SetDisplayMessageResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedSetDisplayMessageResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends SetDisplayMessageAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetDisplayMessageResponse receivedSetDisplayMessageRequest(String id, SetDisplayMessageRequest req){
                logger.info(String.format("\n\n\treceivedSetDisplayMessageRequest(%s)\n", id));
                return SetDisplayMessageResponse.builder().build();
            }

            public void sendSetDisplayMessageResponse(String id, SetDisplayMessageResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendSetDisplayMessageResponse(%s)\n", id), err);
            }
        };
    }
}