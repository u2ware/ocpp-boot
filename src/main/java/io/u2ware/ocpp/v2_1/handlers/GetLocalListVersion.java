package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetLocalListVersionOffer;
import io.u2ware.ocpp.v2_1.actions.GetLocalListVersionAnswer;
import io.u2ware.ocpp.v2_1.model.GetLocalListVersionRequest;
import io.u2ware.ocpp.v2_1.model.GetLocalListVersionResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetLocalListVersion {

    public interface ChargingStationHandler extends GetLocalListVersionOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"GetLocalListVersion"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

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

    public interface CSMSHandler extends GetLocalListVersionAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"GetLocalListVersion"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

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