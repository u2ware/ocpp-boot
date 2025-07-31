package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.UnlockConnectorOffer;
import io.u2ware.ocpp.v1_6.actions.UnlockConnectorAnswer;
import io.u2ware.ocpp.v1_6.model.UnlockConnectorRequest;
import io.u2ware.ocpp.v1_6.model.UnlockConnectorResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface UnlockConnector {

    public interface CentralSystemHandler extends UnlockConnectorOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        default String[] features() { return new String[]{"UnlockConnector"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

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

    public interface ChargePointHandler extends UnlockConnectorAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        default String[] features() { return new String[]{"UnlockConnector"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

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