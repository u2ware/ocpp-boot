package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.OpenPeriodicEventStreamOffer;
import io.u2ware.ocpp.v2_1.actions.OpenPeriodicEventStreamAnswer;
import io.u2ware.ocpp.v2_1.model.OpenPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.OpenPeriodicEventStreamResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface OpenPeriodicEventStream {

    public interface ChargingStationHandler extends OpenPeriodicEventStreamOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public OpenPeriodicEventStreamRequest sendOpenPeriodicEventStreamRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendOpenPeriodicEventStreamRequest(%s)\n", id));
                return OpenPeriodicEventStreamRequest.builder().build();
            }

            public void receivedOpenPeriodicEventStreamResponse(String id, OpenPeriodicEventStreamResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedOpenPeriodicEventStreamResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends OpenPeriodicEventStreamAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public OpenPeriodicEventStreamResponse receivedOpenPeriodicEventStreamRequest(String id, OpenPeriodicEventStreamRequest req){
                logger.info(String.format("\n\n\treceivedOpenPeriodicEventStreamRequest(%s)\n", id));
                return OpenPeriodicEventStreamResponse.builder().build();
            }

            public void sendOpenPeriodicEventStreamResponse(String id, OpenPeriodicEventStreamResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendOpenPeriodicEventStreamResponse(%s)\n", id), err);
            }
        };
    }
}