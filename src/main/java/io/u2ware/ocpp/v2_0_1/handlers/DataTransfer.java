package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.DataTransferOffer;
import io.u2ware.ocpp.v2_0_1.actions.DataTransferAnswer;
import io.u2ware.ocpp.v2_0_1.model.DataTransferRequest;
import io.u2ware.ocpp.v2_0_1.model.DataTransferResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface DataTransfer {

    public interface ChargingStationHandler extends DataTransferOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"DataTransfer"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public DataTransferRequest sendDataTransferRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendDataTransferRequest(%s)\n", id));
                return DataTransferRequest.builder().build();
            }

            public void receivedDataTransferResponse(String id, DataTransferResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedDataTransferResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends DataTransferAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"DataTransfer"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

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