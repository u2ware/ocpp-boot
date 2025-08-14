package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetTariffsOffer;
import io.u2ware.ocpp.v2_1.actions.GetTariffsAnswer;
import io.u2ware.ocpp.v2_1.model.GetTariffsRequest;
import io.u2ware.ocpp.v2_1.model.GetTariffsResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetTariffs {

    public interface CSMSHandler extends GetTariffsOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetTariffsRequest sendGetTariffsRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetTariffsRequest(%s)\n", id));
                return GetTariffsRequest.builder().build();
            }

            public void receivedGetTariffsResponse(String id, GetTariffsResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetTariffsResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends GetTariffsAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetTariffsResponse receivedGetTariffsRequest(String id, GetTariffsRequest req){
                logger.info(String.format("\n\n\treceivedGetTariffsRequest(%s)\n", id));
                return GetTariffsResponse.builder().build();
            }

            public void sendGetTariffsResponse(String id, GetTariffsResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetTariffsResponse(%s)\n", id), err);
            }
        };
    }
}