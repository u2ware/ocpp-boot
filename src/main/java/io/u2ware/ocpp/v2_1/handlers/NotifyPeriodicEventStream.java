package io.u2ware.ocpp.v2_1.handlers;

import io.u2ware.ocpp.v2_1.actions.NotifyPeriodicEventStreamOffer;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyPeriodicEventStreamRequest;
import io.u2ware.ocpp.v2_1.model.NotifyPeriodicEventStreamResponse;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.u2ware.ocpp.v2_1.actions.NotifyPeriodicEventStreamAnswer;

public class NotifyPeriodicEventStream {
 
    public interface ChargingStationHandler extends NotifyPeriodicEventStreamOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"NotifyPeriodicEventStream"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public NotifyPeriodicEventStreamRequest sendNotifyPeriodicEventStreamRequest(String id,
                    Map<String, Object> req) {
                logger.info(String.format("\n\n\t sendNotifyPeriodicEventStreamRequest(%s)\n", id));
                return NotifyPeriodicEventStreamRequest.builder().build();
            }

            @Override
            public void receivedNotifyPeriodicEventStreamResponse(String id, NotifyPeriodicEventStreamResponse res,
                    ErrorCode err) {                
                logger.info(String.format("\n\n\t receivedNotifyPeriodicEventStreamResponse(%s)\n", id));                
            }
        };
    }

    public interface CSMSHandler extends NotifyPeriodicEventStreamAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"NotifyPeriodicEventStream"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public NotifyPeriodicEventStreamResponse receivedNotifyPeriodicEventStreamRequest(String id,
                    NotifyPeriodicEventStreamRequest req) {
                logger.info(String.format("\n\n\t receivedNotifyPeriodicEventStreamRequest(%s)\n", id));
                return null;
            }

            @Override
            public void sendNotifyPeriodicEventStreamResponse(String id, NotifyPeriodicEventStreamResponse res,
                    ErrorCode err) {
                logger.info(String.format("\n\n\t sendNotifyPeriodicEventStreamResponse(%s)\n", id));                
            }
        };
    }
}
