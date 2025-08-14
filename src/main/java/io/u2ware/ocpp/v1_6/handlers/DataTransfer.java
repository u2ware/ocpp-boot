package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.DataTransferOffer;
import io.u2ware.ocpp.v1_6.actions.DataTransferAnswer;
import io.u2ware.ocpp.v1_6.model.DataTransferRequest;
import io.u2ware.ocpp.v1_6.model.DataTransferResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface DataTransfer {

    public interface ChargePointHandler extends DataTransferOffer, DataTransferAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public DataTransferRequest sendDataTransferRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendDataTransferRequest(%s)\n", id));
                return DataTransferRequest.builder().build();
            }

            public void receivedDataTransferResponse(String id, DataTransferResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedDataTransferResponse(%s)\n", id), err);
            }

            public DataTransferResponse receivedDataTransferRequest(String id, DataTransferRequest req){
                logger.info(String.format("\n\n\treceivedDataTransferRequest(%s)\n", id));
                return DataTransferResponse.builder().build();
            }

            public void sendDataTransferResponse(String id, DataTransferResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendDataTransferResponse(%s)\n", id), err);
            }            
        };
    }

    public interface CentralSystemHandler extends DataTransferOffer, DataTransferAnswer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {    

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public DataTransferRequest sendDataTransferRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendDataTransferRequest(%s)\n", id));
                return DataTransferRequest.builder().build();
            }

            public void receivedDataTransferResponse(String id, DataTransferResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedDataTransferResponse(%s)\n", id), err);
            }

            public DataTransferResponse receivedDataTransferRequest(String id, DataTransferRequest req){
                logger.info(String.format("\n\n\treceivedDataTransferRequest(%s)\n", id));
                return DataTransferResponse.builder().build();
            }

            public void sendDataTransferResponse(String id, DataTransferResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendDataTransferResponse(%s)\n", id), err);
            }
        };
    }
}