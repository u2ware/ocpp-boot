package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.HeartbeatOffer;
import io.u2ware.ocpp.v2_0_1.actions.HeartbeatAnswer;
import io.u2ware.ocpp.v2_0_1.model.HeartbeatRequest;
import io.u2ware.ocpp.v2_0_1.model.HeartbeatResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface Heartbeat {

    public interface ChargingStationHandler extends HeartbeatOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"Heartbeat"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public HeartbeatRequest sendHeartbeatRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendHeartbeatRequest(%s)\n", id));
                return HeartbeatRequest.builder().build();
            }

            public void receivedHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedHeartbeatResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends HeartbeatAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"Heartbeat"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public HeartbeatResponse receivedHeartbeatRequest(String id, HeartbeatRequest req){
                logger.info(String.format("\n\n\treceivedHeartbeatRequest(%s)\n", id));
                return HeartbeatResponse.builder().build();
            }

            public void sendHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendHeartbeatResponse(%s)\n", id), err);
            }
        };
    }
}