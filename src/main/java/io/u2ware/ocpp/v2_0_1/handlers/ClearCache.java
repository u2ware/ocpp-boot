package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.ClearCacheOffer;
import io.u2ware.ocpp.v2_0_1.actions.ClearCacheAnswer;
import io.u2ware.ocpp.v2_0_1.model.ClearCacheRequest;
import io.u2ware.ocpp.v2_0_1.model.ClearCacheResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface ClearCache {

    public interface CSMSHandler extends ClearCacheOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"ClearCache"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearCacheRequest sendClearCacheRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendClearCacheRequest(%s)\n", id));
                return ClearCacheRequest.builder().build();
            }

            public void receivedClearCacheResponse(String id, ClearCacheResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedClearCacheResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends ClearCacheAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"ClearCache"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearCacheResponse receivedClearCacheRequest(String id, ClearCacheRequest req){
                logger.info(String.format("\n\n\treceivedClearCacheRequest(%s)\n", id));
                return ClearCacheResponse.builder().build();
            }

            public void sendClearCacheResponse(String id, ClearCacheResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendClearCacheResponse(%s)\n", id), err);
            }
        };
    }
}