package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.NotifyDERStartStopOffer;
import io.u2ware.ocpp.v2_1.actions.NotifyDERStartStopAnswer;
import io.u2ware.ocpp.v2_1.model.NotifyDERStartStopRequest;
import io.u2ware.ocpp.v2_1.model.NotifyDERStartStopResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyDERStartStop {

    public interface ChargingStationHandler extends NotifyDERStartStopOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"NotifyDERStartStop"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyDERStartStopRequest sendNotifyDERStartStopRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyDERStartStopRequest(%s)\n", id));
                return NotifyDERStartStopRequest.builder().build();
            }

            public void receivedNotifyDERStartStopResponse(String id, NotifyDERStartStopResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyDERStartStopResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifyDERStartStopAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"NotifyDERStartStop"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyDERStartStopResponse receivedNotifyDERStartStopRequest(String id, NotifyDERStartStopRequest req){
                logger.info(String.format("\n\n\treceivedNotifyDERStartStopRequest(%s)\n", id));
                return NotifyDERStartStopResponse.builder().build();
            }

            public void sendNotifyDERStartStopResponse(String id, NotifyDERStartStopResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyDERStartStopResponse(%s)\n", id), err);
            }
        };
    }
}