package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.GetLocalListVersionOffer;
import io.u2ware.ocpp.v1_6.actions.GetLocalListVersionAnswer;
import io.u2ware.ocpp.v1_6.model.GetLocalListVersionRequest;
import io.u2ware.ocpp.v1_6.model.GetLocalListVersionResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface GetLocalListVersion {

    public interface CentralSystemHandler extends GetLocalListVersionOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetLocalListVersionRequest sendGetLocalListVersionRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetLocalListVersionRequest(%s)\n", id));
                return GetLocalListVersionRequest.builder().build();
            }

            public void receivedGetLocalListVersionResponse(String id, GetLocalListVersionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetLocalListVersionResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargePointHandler extends GetLocalListVersionAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetLocalListVersionResponse receivedGetLocalListVersionRequest(String id, GetLocalListVersionRequest req){
                logger.info(String.format("\n\n\treceivedGetLocalListVersionRequest(%s)\n", id));
                return GetLocalListVersionResponse.builder().build();
            }

            public void sendGetLocalListVersionResponse(String id, GetLocalListVersionResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetLocalListVersionResponse(%s)\n", id), err);
            }
        };
    }
}