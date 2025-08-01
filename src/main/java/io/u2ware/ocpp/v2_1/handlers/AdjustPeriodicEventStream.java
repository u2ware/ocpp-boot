package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.AdjustPeriodicEventStreamOffer;
import io.u2ware.ocpp.v2_1.actions.AdjustPeriodicEventStreamAnswer;
import io.u2ware.ocpp.v2_1.model.AdjustPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.AdjustPeriodicEventStreamResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface AdjustPeriodicEventStream {

    public interface CSMSHandler extends AdjustPeriodicEventStreamOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"AdjustPeriodicEventStream"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public AdjustPeriodicEventStreamRequest sendAdjustPeriodicEventStreamRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendAdjustPeriodicEventStreamRequest(%s)\n", id));
                return AdjustPeriodicEventStreamRequest.builder().build();
            }

            public void receivedAdjustPeriodicEventStreamResponse(String id, AdjustPeriodicEventStreamResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedAdjustPeriodicEventStreamResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends AdjustPeriodicEventStreamAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"AdjustPeriodicEventStream"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public AdjustPeriodicEventStreamResponse receivedAdjustPeriodicEventStreamRequest(String id, AdjustPeriodicEventStreamRequest req){
                logger.info(String.format("\n\n\treceivedAdjustPeriodicEventStreamRequest(%s)\n", id));
                return AdjustPeriodicEventStreamResponse.builder().build();
            }

            public void sendAdjustPeriodicEventStreamResponse(String id, AdjustPeriodicEventStreamResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendAdjustPeriodicEventStreamResponse(%s)\n", id), err);
            }
        };
    }
}