package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.StartTransactionOffer;
import io.u2ware.ocpp.v1_6.actions.StartTransactionAnswer;
import io.u2ware.ocpp.v1_6.model.StartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StartTransactionResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface StartTransaction {

    public interface ChargePointHandler extends StartTransactionOffer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {

        default String[] features() { return new String[]{"StartTransaction"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public StartTransactionRequest sendStartTransactionRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendStartTransactionRequest(%s)\n", id));
                return StartTransactionRequest.builder().build();
            }

            public void receivedStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedStartTransactionResponse(%s)\n", id), err);
            }
        };
    }

    public interface CentralSystemHandler extends StartTransactionAnswer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {    

        default String[] features() { return new String[]{"StartTransaction"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public StartTransactionResponse receivedStartTransactionRequest(String id, StartTransactionRequest req){
                logger.info(String.format("\n\n\treceivedStartTransactionRequest(%s)\n", id));
                return StartTransactionResponse.builder().build();
            }

            public void sendStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendStartTransactionResponse(%s)\n", id), err);
            }
        };
    }
}