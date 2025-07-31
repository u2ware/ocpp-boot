package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.ClearDisplayMessageOffer;
import io.u2ware.ocpp.v2_0_1.actions.ClearDisplayMessageAnswer;
import io.u2ware.ocpp.v2_0_1.model.ClearDisplayMessageRequest;
import io.u2ware.ocpp.v2_0_1.model.ClearDisplayMessageResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface ClearDisplayMessage {

    public interface CSMSHandler extends ClearDisplayMessageOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"ClearDisplayMessage"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

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

    public interface ChargingStationHandler extends ClearDisplayMessageAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"ClearDisplayMessage"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

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