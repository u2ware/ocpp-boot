package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.RemoteStartTransactionOffer;
import io.u2ware.ocpp.v1_6.actions.RemoteStartTransactionAnswer;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface RemoteStartTransaction {

    public interface CentralSystemHandler extends RemoteStartTransactionOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        default String[] features() { return new String[]{"RemoteStartTransaction"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public RemoteStartTransactionRequest sendRemoteStartTransactionRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendRemoteStartTransactionRequest(%s)\n", id));
                return RemoteStartTransactionRequest.builder().build();
            }

            public void receivedRemoteStartTransactionResponse(String id, RemoteStartTransactionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedRemoteStartTransactionResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargePointHandler extends RemoteStartTransactionAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        default String[] features() { return new String[]{"RemoteStartTransaction"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public RemoteStartTransactionResponse receivedRemoteStartTransactionRequest(String id, RemoteStartTransactionRequest req){
                logger.info(String.format("\n\n\treceivedRemoteStartTransactionRequest(%s)\n", id));
                return RemoteStartTransactionResponse.builder().build();
            }

            public void sendRemoteStartTransactionResponse(String id, RemoteStartTransactionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendRemoteStartTransactionResponse(%s)\n", id), err);
            }
        };
    }
}