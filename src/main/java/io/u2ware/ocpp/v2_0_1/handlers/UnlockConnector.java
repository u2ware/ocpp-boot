package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.UnlockConnectorOffer;
import io.u2ware.ocpp.v2_0_1.actions.UnlockConnectorAnswer;
import io.u2ware.ocpp.v2_0_1.model.UnlockConnectorRequest;
import io.u2ware.ocpp.v2_0_1.model.UnlockConnectorResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface UnlockConnector {

    public interface CSMSHandler extends UnlockConnectorOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public UnlockConnectorRequest sendUnlockConnectorRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendUnlockConnectorRequest(%s)\n", id));
                return UnlockConnectorRequest.builder().build();
            }

            public void receivedUnlockConnectorResponse(String id, UnlockConnectorResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedUnlockConnectorResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends UnlockConnectorAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public UnlockConnectorResponse receivedUnlockConnectorRequest(String id, UnlockConnectorRequest req){
                logger.info(String.format("\n\n\treceivedUnlockConnectorRequest(%s)\n", id));
                return UnlockConnectorResponse.builder().build();
            }

            public void sendUnlockConnectorResponse(String id, UnlockConnectorResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendUnlockConnectorResponse(%s)\n", id), err);
            }
        };
    }
}