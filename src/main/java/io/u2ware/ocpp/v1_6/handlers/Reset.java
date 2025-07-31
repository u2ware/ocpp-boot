package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.ResetOffer;
import io.u2ware.ocpp.v1_6.actions.ResetAnswer;
import io.u2ware.ocpp.v1_6.model.ResetRequest;
import io.u2ware.ocpp.v1_6.model.ResetResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface Reset {

    public interface CentralSystemHandler extends ResetOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        default String[] features() { return new String[]{"Reset"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ResetRequest sendResetRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendResetRequest(%s)\n", id));
                return ResetRequest.builder().build();
            }

            public void receivedResetResponse(String id, ResetResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedResetResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargePointHandler extends ResetAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        default String[] features() { return new String[]{"Reset"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ResetResponse receivedResetRequest(String id, ResetRequest req){
                logger.info(String.format("\n\n\treceivedResetRequest(%s)\n", id));
                return ResetResponse.builder().build();
            }

            public void sendResetResponse(String id, ResetResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendResetResponse(%s)\n", id), err);
            }
        };
    }
}