package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.NotifyDERAlarmOffer;
import io.u2ware.ocpp.v2_1.actions.NotifyDERAlarmAnswer;
import io.u2ware.ocpp.v2_1.model.NotifyDERAlarmRequest;
import io.u2ware.ocpp.v2_1.model.NotifyDERAlarmResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyDERAlarm {

    public interface ChargingStationHandler extends NotifyDERAlarmOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyDERAlarmRequest sendNotifyDERAlarmRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyDERAlarmRequest(%s)\n", id));
                return NotifyDERAlarmRequest.builder().build();
            }

            public void receivedNotifyDERAlarmResponse(String id, NotifyDERAlarmResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyDERAlarmResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifyDERAlarmAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyDERAlarmResponse receivedNotifyDERAlarmRequest(String id, NotifyDERAlarmRequest req){
                logger.info(String.format("\n\n\treceivedNotifyDERAlarmRequest(%s)\n", id));
                return NotifyDERAlarmResponse.builder().build();
            }

            public void sendNotifyDERAlarmResponse(String id, NotifyDERAlarmResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyDERAlarmResponse(%s)\n", id), err);
            }
        };
    }
}