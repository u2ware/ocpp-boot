package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetTransactionStatusOffer;
import io.u2ware.ocpp.v2_1.actions.GetTransactionStatusAnswer;
import io.u2ware.ocpp.v2_1.model.GetTransactionStatusRequest;
import io.u2ware.ocpp.v2_1.model.GetTransactionStatusResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetTransactionStatus {

    public interface CSMSHandler extends GetTransactionStatusOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetTransactionStatusRequest sendGetTransactionStatusRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetTransactionStatusRequest(%s)\n", id));
                return GetTransactionStatusRequest.builder().build();
            }

            public void receivedGetTransactionStatusResponse(String id, GetTransactionStatusResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetTransactionStatusResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends GetTransactionStatusAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetTransactionStatusResponse receivedGetTransactionStatusRequest(String id, GetTransactionStatusRequest req){
                logger.info(String.format("\n\n\treceivedGetTransactionStatusRequest(%s)\n", id));
                return GetTransactionStatusResponse.builder().build();
            }

            public void sendGetTransactionStatusResponse(String id, GetTransactionStatusResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetTransactionStatusResponse(%s)\n", id), err);
            }
        };
    }
}