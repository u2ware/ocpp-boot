package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.GetCompositeScheduleOffer;
import io.u2ware.ocpp.v1_6.actions.GetCompositeScheduleAnswer;
import io.u2ware.ocpp.v1_6.model.GetCompositeScheduleRequest;
import io.u2ware.ocpp.v1_6.model.GetCompositeScheduleResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface GetCompositeSchedule {

    public interface CentralSystemHandler extends GetCompositeScheduleOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        default String[] features() { return new String[]{"GetCompositeSchedule"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

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

    public interface ChargePointHandler extends GetCompositeScheduleAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        default String[] features() { return new String[]{"GetCompositeSchedule"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

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