package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.CustomerInformationOffer;
import io.u2ware.ocpp.v2_1.actions.CustomerInformationAnswer;
import io.u2ware.ocpp.v2_1.model.CustomerInformationRequest;
import io.u2ware.ocpp.v2_1.model.CustomerInformationResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface CustomerInformation {

    public interface CSMSHandler extends CustomerInformationOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"CustomerInformation"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public CustomerInformationRequest sendCustomerInformationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendCustomerInformationRequest(%s)\n", id));
                return CustomerInformationRequest.builder().build();
            }

            public void receivedCustomerInformationResponse(String id, CustomerInformationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedCustomerInformationResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends CustomerInformationAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"CustomerInformation"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public CustomerInformationResponse receivedCustomerInformationRequest(String id, CustomerInformationRequest req){
                logger.info(String.format("\n\n\treceivedCustomerInformationRequest(%s)\n", id));
                return CustomerInformationResponse.builder().build();
            }

            public void sendCustomerInformationResponse(String id, CustomerInformationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendCustomerInformationResponse(%s)\n", id), err);
            }
        };
    }
}