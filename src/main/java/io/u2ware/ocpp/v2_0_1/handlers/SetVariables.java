package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.SetVariablesOffer;
import io.u2ware.ocpp.v2_0_1.actions.SetVariablesAnswer;
import io.u2ware.ocpp.v2_0_1.model.SetVariablesRequest;
import io.u2ware.ocpp.v2_0_1.model.SetVariablesResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface SetVariables {

    public interface CSMSHandler extends SetVariablesOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetVariablesRequest sendSetVariablesRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendSetVariablesRequest(%s)\n", id));
                return SetVariablesRequest.builder().build();
            }

            public void receivedSetVariablesResponse(String id, SetVariablesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedSetVariablesResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends SetVariablesAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetVariablesResponse receivedSetVariablesRequest(String id, SetVariablesRequest req){
                logger.info(String.format("\n\n\treceivedSetVariablesRequest(%s)\n", id));
                return SetVariablesResponse.builder().build();
            }

            public void sendSetVariablesResponse(String id, SetVariablesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendSetVariablesResponse(%s)\n", id), err);
            }
        };
    }
}