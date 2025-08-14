package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetPeriodicEventStreamOffer;
import io.u2ware.ocpp.v2_1.actions.GetPeriodicEventStreamAnswer;
import io.u2ware.ocpp.v2_1.model.GetPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.GetPeriodicEventStreamResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetPeriodicEventStream {

    public interface CSMSHandler extends GetPeriodicEventStreamOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetPeriodicEventStreamRequest sendGetPeriodicEventStreamRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetPeriodicEventStreamRequest(%s)\n", id));
                return GetPeriodicEventStreamRequest.builder().build();
            }

            public void receivedGetPeriodicEventStreamResponse(String id, GetPeriodicEventStreamResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetPeriodicEventStreamResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends GetPeriodicEventStreamAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetPeriodicEventStreamResponse receivedGetPeriodicEventStreamRequest(String id, GetPeriodicEventStreamRequest req){
                logger.info(String.format("\n\n\treceivedGetPeriodicEventStreamRequest(%s)\n", id));
                return GetPeriodicEventStreamResponse.builder().build();
            }

            public void sendGetPeriodicEventStreamResponse(String id, GetPeriodicEventStreamResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetPeriodicEventStreamResponse(%s)\n", id), err);
            }
        };
    }
}