package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.ClosePeriodicEventStreamOffer;
import io.u2ware.ocpp.v2_1.actions.ClosePeriodicEventStreamAnswer;
import io.u2ware.ocpp.v2_1.model.ClosePeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.ClosePeriodicEventStreamResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ClosePeriodicEventStream {

    public interface CSMSHandler extends ClosePeriodicEventStreamOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClosePeriodicEventStreamRequest sendClosePeriodicEventStreamRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendClosePeriodicEventStreamRequest(%s)\n", id));
                return ClosePeriodicEventStreamRequest.builder().build();
            }

            public void receivedClosePeriodicEventStreamResponse(String id, ClosePeriodicEventStreamResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedClosePeriodicEventStreamResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends ClosePeriodicEventStreamAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClosePeriodicEventStreamResponse receivedClosePeriodicEventStreamRequest(String id, ClosePeriodicEventStreamRequest req){
                logger.info(String.format("\n\n\treceivedClosePeriodicEventStreamRequest(%s)\n", id));
                return ClosePeriodicEventStreamResponse.builder().build();
            }

            public void sendClosePeriodicEventStreamResponse(String id, ClosePeriodicEventStreamResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendClosePeriodicEventStreamResponse(%s)\n", id), err);
            }
        };
    }
}