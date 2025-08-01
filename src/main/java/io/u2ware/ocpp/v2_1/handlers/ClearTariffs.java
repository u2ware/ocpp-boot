package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.ClearTariffsOffer;
import io.u2ware.ocpp.v2_1.actions.ClearTariffsAnswer;
import io.u2ware.ocpp.v2_1.model.ClearTariffsRequest;
import io.u2ware.ocpp.v2_1.model.ClearTariffsResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ClearTariffs {

    public interface CSMSHandler extends ClearTariffsOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"ClearTariffs"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearTariffsRequest sendClearTariffsRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendClearTariffsRequest(%s)\n", id));
                return ClearTariffsRequest.builder().build();
            }

            public void receivedClearTariffsResponse(String id, ClearTariffsResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedClearTariffsResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends ClearTariffsAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"ClearTariffs"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearTariffsResponse receivedClearTariffsRequest(String id, ClearTariffsRequest req){
                logger.info(String.format("\n\n\treceivedClearTariffsRequest(%s)\n", id));
                return ClearTariffsResponse.builder().build();
            }

            public void sendClearTariffsResponse(String id, ClearTariffsResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendClearTariffsResponse(%s)\n", id), err);
            }
        };
    }
}