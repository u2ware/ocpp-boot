package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.RequestBatterySwapOffer;
import io.u2ware.ocpp.v2_1.actions.RequestBatterySwapAnswer;
import io.u2ware.ocpp.v2_1.model.RequestBatterySwapRequest;
import io.u2ware.ocpp.v2_1.model.RequestBatterySwapResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface RequestBatterySwap {

    public interface CSMSHandler extends RequestBatterySwapOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"RequestBatterySwap"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public RequestBatterySwapRequest sendRequestBatterySwapRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendRequestBatterySwapRequest(%s)\n", id));
                return RequestBatterySwapRequest.builder().build();
            }

            public void receivedRequestBatterySwapResponse(String id, RequestBatterySwapResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedRequestBatterySwapResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends RequestBatterySwapAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"RequestBatterySwap"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public RequestBatterySwapResponse receivedRequestBatterySwapRequest(String id, RequestBatterySwapRequest req){
                logger.info(String.format("\n\n\treceivedRequestBatterySwapRequest(%s)\n", id));
                return RequestBatterySwapResponse.builder().build();
            }

            public void sendRequestBatterySwapResponse(String id, RequestBatterySwapResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendRequestBatterySwapResponse(%s)\n", id), err);
            }
        };
    }
}