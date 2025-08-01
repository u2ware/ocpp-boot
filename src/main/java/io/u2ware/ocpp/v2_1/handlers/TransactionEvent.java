package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.TransactionEventOffer;
import io.u2ware.ocpp.v2_1.actions.TransactionEventAnswer;
import io.u2ware.ocpp.v2_1.model.TransactionEventRequest;
import io.u2ware.ocpp.v2_1.model.TransactionEventResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface TransactionEvent {

    public interface ChargingStationHandler extends TransactionEventOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"TransactionEvent"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public TransactionEventRequest sendTransactionEventRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendTransactionEventRequest(%s)\n", id));
                return TransactionEventRequest.builder().build();
            }

            public void receivedTransactionEventResponse(String id, TransactionEventResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedTransactionEventResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends TransactionEventAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"TransactionEvent"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public TransactionEventResponse receivedTransactionEventRequest(String id, TransactionEventRequest req){
                logger.info(String.format("\n\n\treceivedTransactionEventRequest(%s)\n", id));
                return TransactionEventResponse.builder().build();
            }

            public void sendTransactionEventResponse(String id, TransactionEventResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendTransactionEventResponse(%s)\n", id), err);
            }
        };
    }
}