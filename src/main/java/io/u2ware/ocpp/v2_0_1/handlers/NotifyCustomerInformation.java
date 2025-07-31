package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.NotifyCustomerInformationOffer;
import io.u2ware.ocpp.v2_0_1.actions.NotifyCustomerInformationAnswer;
import io.u2ware.ocpp.v2_0_1.model.NotifyCustomerInformationRequest;
import io.u2ware.ocpp.v2_0_1.model.NotifyCustomerInformationResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface NotifyCustomerInformation {

    public interface ChargingStationHandler extends NotifyCustomerInformationOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"NotifyCustomerInformation"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyCustomerInformationRequest sendNotifyCustomerInformationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyCustomerInformationRequest(%s)\n", id));
                return NotifyCustomerInformationRequest.builder().build();
            }

            public void receivedNotifyCustomerInformationResponse(String id, NotifyCustomerInformationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyCustomerInformationResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifyCustomerInformationAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"NotifyCustomerInformation"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyCustomerInformationResponse receivedNotifyCustomerInformationRequest(String id, NotifyCustomerInformationRequest req){
                logger.info(String.format("\n\n\treceivedNotifyCustomerInformationRequest(%s)\n", id));
                return NotifyCustomerInformationResponse.builder().build();
            }

            public void sendNotifyCustomerInformationResponse(String id, NotifyCustomerInformationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyCustomerInformationResponse(%s)\n", id), err);
            }
        };
    }
}