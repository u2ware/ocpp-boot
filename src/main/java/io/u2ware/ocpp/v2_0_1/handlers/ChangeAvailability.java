package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.ChangeAvailabilityOffer;
import io.u2ware.ocpp.v2_0_1.actions.ChangeAvailabilityAnswer;
import io.u2ware.ocpp.v2_0_1.model.ChangeAvailabilityRequest;
import io.u2ware.ocpp.v2_0_1.model.ChangeAvailabilityResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface ChangeAvailability {

    public interface CSMSHandler extends ChangeAvailabilityOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"ChangeAvailability"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

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

    public interface ChargingStationHandler extends ChangeAvailabilityAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"ChangeAvailability"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

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