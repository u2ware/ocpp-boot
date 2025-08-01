package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.RequestStopTransactionOffer;
import io.u2ware.ocpp.v2_1.actions.RequestStopTransactionAnswer;
import io.u2ware.ocpp.v2_1.model.RequestStopTransactionRequest;
import io.u2ware.ocpp.v2_1.model.RequestStopTransactionResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface RequestStopTransaction {

    public interface CSMSHandler extends RequestStopTransactionOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"RequestStopTransaction"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public RequestStopTransactionRequest sendRequestStopTransactionRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendRequestStopTransactionRequest(%s)\n", id));
                return RequestStopTransactionRequest.builder().build();
            }

            public void receivedRequestStopTransactionResponse(String id, RequestStopTransactionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedRequestStopTransactionResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends RequestStopTransactionAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"RequestStopTransaction"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public RequestStopTransactionResponse receivedRequestStopTransactionRequest(String id, RequestStopTransactionRequest req){
                logger.info(String.format("\n\n\treceivedRequestStopTransactionRequest(%s)\n", id));
                return RequestStopTransactionResponse.builder().build();
            }

            public void sendRequestStopTransactionResponse(String id, RequestStopTransactionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendRequestStopTransactionResponse(%s)\n", id), err);
            }
        };
    }
}