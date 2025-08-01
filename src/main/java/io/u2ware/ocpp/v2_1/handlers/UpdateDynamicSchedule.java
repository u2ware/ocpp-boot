package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.UpdateDynamicScheduleOffer;
import io.u2ware.ocpp.v2_1.actions.UpdateDynamicScheduleAnswer;
import io.u2ware.ocpp.v2_1.model.UpdateDynamicScheduleRequest;
import io.u2ware.ocpp.v2_1.model.UpdateDynamicScheduleResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface UpdateDynamicSchedule {

    public interface CSMSHandler extends UpdateDynamicScheduleOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"UpdateDynamicSchedule"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public UpdateDynamicScheduleRequest sendUpdateDynamicScheduleRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendUpdateDynamicScheduleRequest(%s)\n", id));
                return UpdateDynamicScheduleRequest.builder().build();
            }

            public void receivedUpdateDynamicScheduleResponse(String id, UpdateDynamicScheduleResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedUpdateDynamicScheduleResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends UpdateDynamicScheduleAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"UpdateDynamicSchedule"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public UpdateDynamicScheduleResponse receivedUpdateDynamicScheduleRequest(String id, UpdateDynamicScheduleRequest req){
                logger.info(String.format("\n\n\treceivedUpdateDynamicScheduleRequest(%s)\n", id));
                return UpdateDynamicScheduleResponse.builder().build();
            }

            public void sendUpdateDynamicScheduleResponse(String id, UpdateDynamicScheduleResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendUpdateDynamicScheduleResponse(%s)\n", id), err);
            }
        };
    }
}