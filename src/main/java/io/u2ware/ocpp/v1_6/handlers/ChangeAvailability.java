package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.ChangeAvailabilityOffer;
import io.u2ware.ocpp.v1_6.actions.ChangeAvailabilityAnswer;
import io.u2ware.ocpp.v1_6.model.ChangeAvailabilityRequest;
import io.u2ware.ocpp.v1_6.model.ChangeAvailabilityResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface ChangeAvailability {

    public interface CentralSystemHandler extends ChangeAvailabilityOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        default String[] features() { return new String[]{"ChangeAvailability"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ChangeAvailabilityRequest sendChangeAvailabilityRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendChangeAvailabilityRequest(%s)\n", id));
                return ChangeAvailabilityRequest.builder().build();
            }

            public void receivedChangeAvailabilityResponse(String id, ChangeAvailabilityResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedChangeAvailabilityResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargePointHandler extends ChangeAvailabilityAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        default String[] features() { return new String[]{"ChangeAvailability"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ChangeAvailabilityResponse receivedChangeAvailabilityRequest(String id, ChangeAvailabilityRequest req){
                logger.info(String.format("\n\n\treceivedChangeAvailabilityRequest(%s)\n", id));
                return ChangeAvailabilityResponse.builder().build();
            }

            public void sendChangeAvailabilityResponse(String id, ChangeAvailabilityResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendChangeAvailabilityResponse(%s)\n", id), err);
            }
        };
    }
}