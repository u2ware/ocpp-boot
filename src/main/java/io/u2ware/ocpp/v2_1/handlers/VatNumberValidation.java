package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.VatNumberValidationOffer;
import io.u2ware.ocpp.v2_1.actions.VatNumberValidationAnswer;
import io.u2ware.ocpp.v2_1.model.VatNumberValidationRequest;
import io.u2ware.ocpp.v2_1.model.VatNumberValidationResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface VatNumberValidation {

    public interface CSMSHandler extends VatNumberValidationOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public VatNumberValidationRequest sendVatNumberValidationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendVatNumberValidationRequest(%s)\n", id));
                return VatNumberValidationRequest.builder().build();
            }

            public void receivedVatNumberValidationResponse(String id, VatNumberValidationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedVatNumberValidationResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends VatNumberValidationAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public VatNumberValidationResponse receivedVatNumberValidationRequest(String id, VatNumberValidationRequest req){
                logger.info(String.format("\n\n\treceivedVatNumberValidationRequest(%s)\n", id));
                return VatNumberValidationResponse.builder().build();
            }

            public void sendVatNumberValidationResponse(String id, VatNumberValidationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendVatNumberValidationResponse(%s)\n", id), err);
            }
        };
    }
}