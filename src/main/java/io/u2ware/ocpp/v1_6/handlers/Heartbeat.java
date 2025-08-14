package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.HeartbeatOffer;
import io.u2ware.ocpp.v1_6.actions.HeartbeatAnswer;
import io.u2ware.ocpp.v1_6.model.HeartbeatRequest;
import io.u2ware.ocpp.v1_6.model.HeartbeatResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface Heartbeat {

    public interface ChargePointHandler extends HeartbeatOffer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

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

    public interface CentralSystemHandler extends HeartbeatAnswer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {    

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

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