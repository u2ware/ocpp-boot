package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.StopTransactionOffer;
import io.u2ware.ocpp.v1_6.actions.StopTransactionAnswer;
import io.u2ware.ocpp.v1_6.model.StopTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StopTransactionResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface StopTransaction {

    public interface ChargePointHandler extends StopTransactionOffer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {

        default String[] features() { return new String[]{"StopTransaction"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public StopTransactionRequest sendStopTransactionRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendStopTransactionRequest(%s)\n", id));
                return StopTransactionRequest.builder().build();
            }

            public void receivedStopTransactionResponse(String id, StopTransactionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedStopTransactionResponse(%s)\n", id), err);
            }
        };
    }

    public interface CentralSystemHandler extends StopTransactionAnswer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {    

        default String[] features() { return new String[]{"StopTransaction"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public StopTransactionResponse receivedStopTransactionRequest(String id, StopTransactionRequest req){
                logger.info(String.format("\n\n\treceivedStopTransactionRequest(%s)\n", id));
                return StopTransactionResponse.builder().build();
            }

            public void sendStopTransactionResponse(String id, StopTransactionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendStopTransactionResponse(%s)\n", id), err);
            }
        };
    }
}