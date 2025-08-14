package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetLogOffer;
import io.u2ware.ocpp.v2_1.actions.GetLogAnswer;
import io.u2ware.ocpp.v2_1.model.GetLogRequest;
import io.u2ware.ocpp.v2_1.model.GetLogResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetLog {

    public interface CSMSHandler extends GetLogOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetLogRequest sendGetLogRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetLogRequest(%s)\n", id));
                return GetLogRequest.builder().build();
            }

            public void receivedGetLogResponse(String id, GetLogResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetLogResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends GetLogAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetLogResponse receivedGetLogRequest(String id, GetLogRequest req){
                logger.info(String.format("\n\n\treceivedGetLogRequest(%s)\n", id));
                return GetLogResponse.builder().build();
            }

            public void sendGetLogResponse(String id, GetLogResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetLogResponse(%s)\n", id), err);
            }
        };
    }
}