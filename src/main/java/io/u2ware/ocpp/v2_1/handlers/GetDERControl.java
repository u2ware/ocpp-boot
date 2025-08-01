package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetDERControlOffer;
import io.u2ware.ocpp.v2_1.actions.GetDERControlAnswer;
import io.u2ware.ocpp.v2_1.model.GetDERControlRequest;
import io.u2ware.ocpp.v2_1.model.GetDERControlResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetDERControl {

    public interface CSMSHandler extends GetDERControlOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"GetDERControl"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetDERControlRequest sendGetDERControlRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetDERControlRequest(%s)\n", id));
                return GetDERControlRequest.builder().build();
            }

            public void receivedGetDERControlResponse(String id, GetDERControlResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetDERControlResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends GetDERControlAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"GetDERControl"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetDERControlResponse receivedGetDERControlRequest(String id, GetDERControlRequest req){
                logger.info(String.format("\n\n\treceivedGetDERControlRequest(%s)\n", id));
                return GetDERControlResponse.builder().build();
            }

            public void sendGetDERControlResponse(String id, GetDERControlResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetDERControlResponse(%s)\n", id), err);
            }
        };
    }
}