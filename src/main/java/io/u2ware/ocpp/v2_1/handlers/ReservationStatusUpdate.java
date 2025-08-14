package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.ReservationStatusUpdateOffer;
import io.u2ware.ocpp.v2_1.actions.ReservationStatusUpdateAnswer;
import io.u2ware.ocpp.v2_1.model.ReservationStatusUpdateRequest;
import io.u2ware.ocpp.v2_1.model.ReservationStatusUpdateResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ReservationStatusUpdate {

    public interface ChargingStationHandler extends ReservationStatusUpdateOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ReservationStatusUpdateRequest sendReservationStatusUpdateRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendReservationStatusUpdateRequest(%s)\n", id));
                return ReservationStatusUpdateRequest.builder().build();
            }

            public void receivedReservationStatusUpdateResponse(String id, ReservationStatusUpdateResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedReservationStatusUpdateResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends ReservationStatusUpdateAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ReservationStatusUpdateResponse receivedReservationStatusUpdateRequest(String id, ReservationStatusUpdateRequest req){
                logger.info(String.format("\n\n\treceivedReservationStatusUpdateRequest(%s)\n", id));
                return ReservationStatusUpdateResponse.builder().build();
            }

            public void sendReservationStatusUpdateResponse(String id, ReservationStatusUpdateResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendReservationStatusUpdateResponse(%s)\n", id), err);
            }
        };
    }
}