package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.NotifyEventOffer;
import io.u2ware.ocpp.v2_1.actions.NotifyEventAnswer;
import io.u2ware.ocpp.v2_1.model.NotifyEventRequest;
import io.u2ware.ocpp.v2_1.model.NotifyEventResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyEvent {

    public interface ChargingStationHandler extends NotifyEventOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"NotifyEvent"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyEventRequest sendNotifyEventRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyEventRequest(%s)\n", id));
                return NotifyEventRequest.builder().build();
            }

            public void receivedNotifyEventResponse(String id, NotifyEventResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyEventResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifyEventAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"NotifyEvent"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyEventResponse receivedNotifyEventRequest(String id, NotifyEventRequest req){
                logger.info(String.format("\n\n\treceivedNotifyEventRequest(%s)\n", id));
                return NotifyEventResponse.builder().build();
            }

            public void sendNotifyEventResponse(String id, NotifyEventResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyEventResponse(%s)\n", id), err);
            }
        };
    }
}