package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.GetVariablesOffer;
import io.u2ware.ocpp.v2_0_1.actions.GetVariablesAnswer;
import io.u2ware.ocpp.v2_0_1.model.GetVariablesRequest;
import io.u2ware.ocpp.v2_0_1.model.GetVariablesResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface GetVariables {

    public interface CSMSHandler extends GetVariablesOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetVariablesRequest sendGetVariablesRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetVariablesRequest(%s)\n", id));
                return GetVariablesRequest.builder().build();
            }

            public void receivedGetVariablesResponse(String id, GetVariablesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetVariablesResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends GetVariablesAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetVariablesResponse receivedGetVariablesRequest(String id, GetVariablesRequest req){
                logger.info(String.format("\n\n\treceivedGetVariablesRequest(%s)\n", id));
                return GetVariablesResponse.builder().build();
            }

            public void sendGetVariablesResponse(String id, GetVariablesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetVariablesResponse(%s)\n", id), err);
            }
        };
    }
}