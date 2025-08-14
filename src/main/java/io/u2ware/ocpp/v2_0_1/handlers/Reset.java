package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.ResetOffer;
import io.u2ware.ocpp.v2_0_1.actions.ResetAnswer;
import io.u2ware.ocpp.v2_0_1.model.ResetRequest;
import io.u2ware.ocpp.v2_0_1.model.ResetResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface Reset {

    public interface CSMSHandler extends ResetOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

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

    public interface ChargingStationHandler extends ResetAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

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