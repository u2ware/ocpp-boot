package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.PullDynamicScheduleUpdateOffer;
import io.u2ware.ocpp.v2_1.actions.PullDynamicScheduleUpdateAnswer;
import io.u2ware.ocpp.v2_1.model.PullDynamicScheduleUpdateRequest;
import io.u2ware.ocpp.v2_1.model.PullDynamicScheduleUpdateResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface PullDynamicScheduleUpdate {

    public interface ChargingStationHandler extends PullDynamicScheduleUpdateOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"PullDynamicScheduleUpdate"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public PullDynamicScheduleUpdateRequest sendPullDynamicScheduleUpdateRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendPullDynamicScheduleUpdateRequest(%s)\n", id));
                return PullDynamicScheduleUpdateRequest.builder().build();
            }

            public void receivedPullDynamicScheduleUpdateResponse(String id, PullDynamicScheduleUpdateResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedPullDynamicScheduleUpdateResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends PullDynamicScheduleUpdateAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"PullDynamicScheduleUpdate"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public PullDynamicScheduleUpdateResponse receivedPullDynamicScheduleUpdateRequest(String id, PullDynamicScheduleUpdateRequest req){
                logger.info(String.format("\n\n\treceivedPullDynamicScheduleUpdateRequest(%s)\n", id));
                return PullDynamicScheduleUpdateResponse.builder().build();
            }

            public void sendPullDynamicScheduleUpdateResponse(String id, PullDynamicScheduleUpdateResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendPullDynamicScheduleUpdateResponse(%s)\n", id), err);
            }
        };
    }
}