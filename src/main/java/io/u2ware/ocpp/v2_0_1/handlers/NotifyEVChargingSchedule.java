package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.NotifyEVChargingScheduleOffer;
import io.u2ware.ocpp.v2_0_1.actions.NotifyEVChargingScheduleAnswer;
import io.u2ware.ocpp.v2_0_1.model.NotifyEVChargingScheduleRequest;
import io.u2ware.ocpp.v2_0_1.model.NotifyEVChargingScheduleResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface NotifyEVChargingSchedule {

    public interface ChargingStationHandler extends NotifyEVChargingScheduleOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"NotifyEVChargingSchedule"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyEVChargingScheduleRequest sendNotifyEVChargingScheduleRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyEVChargingScheduleRequest(%s)\n", id));
                return NotifyEVChargingScheduleRequest.builder().build();
            }

            public void receivedNotifyEVChargingScheduleResponse(String id, NotifyEVChargingScheduleResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyEVChargingScheduleResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifyEVChargingScheduleAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"NotifyEVChargingSchedule"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyEVChargingScheduleResponse receivedNotifyEVChargingScheduleRequest(String id, NotifyEVChargingScheduleRequest req){
                logger.info(String.format("\n\n\treceivedNotifyEVChargingScheduleRequest(%s)\n", id));
                return NotifyEVChargingScheduleResponse.builder().build();
            }

            public void sendNotifyEVChargingScheduleResponse(String id, NotifyEVChargingScheduleResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyEVChargingScheduleResponse(%s)\n", id), err);
            }
        };
    }
}