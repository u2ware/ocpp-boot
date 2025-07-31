package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.RemoteStopTransactionOffer;
import io.u2ware.ocpp.v1_6.actions.RemoteStopTransactionAnswer;
import io.u2ware.ocpp.v1_6.model.RemoteStopTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStopTransactionResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface RemoteStopTransaction {

    public interface CentralSystemHandler extends RemoteStopTransactionOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        default String[] features() { return new String[]{"RemoteStopTransaction"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public RemoteStopTransactionRequest sendRemoteStopTransactionRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendRemoteStopTransactionRequest(%s)\n", id));
                return RemoteStopTransactionRequest.builder().build();
            }

            public void receivedRemoteStopTransactionResponse(String id, RemoteStopTransactionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedRemoteStopTransactionResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargePointHandler extends RemoteStopTransactionAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        default String[] features() { return new String[]{"RemoteStopTransaction"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public RemoteStopTransactionResponse receivedRemoteStopTransactionRequest(String id, RemoteStopTransactionRequest req){
                logger.info(String.format("\n\n\treceivedRemoteStopTransactionRequest(%s)\n", id));
                return RemoteStopTransactionResponse.builder().build();
            }

            public void sendRemoteStopTransactionResponse(String id, RemoteStopTransactionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendRemoteStopTransactionResponse(%s)\n", id), err);
            }
        };
    }
}