package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetCompositeScheduleOffer;
import io.u2ware.ocpp.v2_1.actions.GetCompositeScheduleAnswer;
import io.u2ware.ocpp.v2_1.model.GetCompositeScheduleRequest;
import io.u2ware.ocpp.v2_1.model.GetCompositeScheduleResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetCompositeSchedule {

    public interface ChargingStationHandler extends GetCompositeScheduleOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetCompositeScheduleRequest sendGetCompositeScheduleRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetCompositeScheduleRequest(%s)\n", id));
                return GetCompositeScheduleRequest.builder().build();
            }

            public void receivedGetCompositeScheduleResponse(String id, GetCompositeScheduleResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetCompositeScheduleResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends GetCompositeScheduleAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetCompositeScheduleResponse receivedGetCompositeScheduleRequest(String id, GetCompositeScheduleRequest req){
                logger.info(String.format("\n\n\treceivedGetCompositeScheduleRequest(%s)\n", id));
                return GetCompositeScheduleResponse.builder().build();
            }

            public void sendGetCompositeScheduleResponse(String id, GetCompositeScheduleResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetCompositeScheduleResponse(%s)\n", id), err);
            }
        };
    }
}