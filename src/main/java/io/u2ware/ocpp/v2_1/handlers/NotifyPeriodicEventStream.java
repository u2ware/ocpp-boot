package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.NotifyPeriodicEventStreamOffer;
import io.u2ware.ocpp.v2_1.actions.NotifyPeriodicEventStreamAnswer;
import io.u2ware.ocpp.v2_1.model.NotifyPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.NotifyPeriodicEventStreamResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyPeriodicEventStream {
    

    public interface ChargingStationHandler extends NotifyPeriodicEventStreamOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public NotifyPeriodicEventStreamRequest sendNotifyPeriodicEventStreamRequest(String id,
                    Map<String, Object> req) {
                logger.info(String.format("\n\n\tsendNotifyPeriodicEventStreamRequest(%s)\n", id));
                return NotifyPeriodicEventStreamRequest.builder().build();
            }

            @Override
            public void receivedNotifyPeriodicEventStreamResponse(String id, NotifyPeriodicEventStreamResponse res,
                    ErrorCode err) {
                logger.info(String.format("\n\n\treceivedNotifyPeriodicEventStreamResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifyPeriodicEventStreamAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public NotifyPeriodicEventStreamResponse receivedNotifyPeriodicEventStreamRequest(String id,
                    NotifyPeriodicEventStreamRequest req) {
                logger.info(String.format("\n\n\treceivedNotifyPeriodicEventStreamRequest(%s)\n", id));
                return NotifyPeriodicEventStreamResponse.builder().build();
            }

            @Override
            public void sendNotifyPeriodicEventStreamResponse(String id, NotifyPeriodicEventStreamResponse res,
                    ErrorCode err) {
                logger.info(String.format("\n\n\tsendNotifyPeriodicEventStreamResponse(%s)\n", id), err);
            }
        };
    }

}
