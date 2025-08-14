package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.RequestStartTransactionOffer;
import io.u2ware.ocpp.v2_1.actions.RequestStartTransactionAnswer;
import io.u2ware.ocpp.v2_1.model.RequestStartTransactionRequest;
import io.u2ware.ocpp.v2_1.model.RequestStartTransactionResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface RequestStartTransaction {

    public interface CSMSHandler extends RequestStartTransactionOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public RequestStartTransactionRequest sendRequestStartTransactionRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendRequestStartTransactionRequest(%s)\n", id));
                return RequestStartTransactionRequest.builder().build();
            }

            public void receivedRequestStartTransactionResponse(String id, RequestStartTransactionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedRequestStartTransactionResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends RequestStartTransactionAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public RequestStartTransactionResponse receivedRequestStartTransactionRequest(String id, RequestStartTransactionRequest req){
                logger.info(String.format("\n\n\treceivedRequestStartTransactionRequest(%s)\n", id));
                return RequestStartTransactionResponse.builder().build();
            }

            public void sendRequestStartTransactionResponse(String id, RequestStartTransactionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendRequestStartTransactionResponse(%s)\n", id), err);
            }
        };
    }
}