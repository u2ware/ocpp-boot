package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.CancelReservationOffer;
import io.u2ware.ocpp.v1_6.actions.CancelReservationAnswer;
import io.u2ware.ocpp.v1_6.model.CancelReservationRequest;
import io.u2ware.ocpp.v1_6.model.CancelReservationResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface CancelReservation {

    public interface CentralSystemHandler extends CancelReservationOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public CancelReservationRequest sendCancelReservationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendCancelReservationRequest(%s)\n", id));
                return CancelReservationRequest.builder().build();
            }

            public void receivedCancelReservationResponse(String id, CancelReservationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedCancelReservationResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargePointHandler extends CancelReservationAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public CancelReservationResponse receivedCancelReservationRequest(String id, CancelReservationRequest req){
                logger.info(String.format("\n\n\treceivedCancelReservationRequest(%s)\n", id));
                return CancelReservationResponse.builder().build();
            }

            public void sendCancelReservationResponse(String id, CancelReservationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendCancelReservationResponse(%s)\n", id), err);
            }
        };
    }
}