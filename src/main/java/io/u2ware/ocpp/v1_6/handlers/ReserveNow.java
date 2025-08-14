package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.ReserveNowOffer;
import io.u2ware.ocpp.v1_6.actions.ReserveNowAnswer;
import io.u2ware.ocpp.v1_6.model.ReserveNowRequest;
import io.u2ware.ocpp.v1_6.model.ReserveNowResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface ReserveNow {

    public interface CentralSystemHandler extends ReserveNowOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ReserveNowRequest sendReserveNowRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendReserveNowRequest(%s)\n", id));
                return ReserveNowRequest.builder().build();
            }

            public void receivedReserveNowResponse(String id, ReserveNowResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedReserveNowResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargePointHandler extends ReserveNowAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ReserveNowResponse receivedReserveNowRequest(String id, ReserveNowRequest req){
                logger.info(String.format("\n\n\treceivedReserveNowRequest(%s)\n", id));
                return ReserveNowResponse.builder().build();
            }

            public void sendReserveNowResponse(String id, ReserveNowResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendReserveNowResponse(%s)\n", id), err);
            }
        };
    }
}