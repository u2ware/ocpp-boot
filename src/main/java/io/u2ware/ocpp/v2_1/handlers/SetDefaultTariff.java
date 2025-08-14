package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.SetDefaultTariffOffer;
import io.u2ware.ocpp.v2_1.actions.SetDefaultTariffAnswer;
import io.u2ware.ocpp.v2_1.model.SetDefaultTariffRequest;
import io.u2ware.ocpp.v2_1.model.SetDefaultTariffResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SetDefaultTariff {

    public interface CSMSHandler extends SetDefaultTariffOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetDefaultTariffRequest sendSetDefaultTariffRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendSetDefaultTariffRequest(%s)\n", id));
                return SetDefaultTariffRequest.builder().build();
            }

            public void receivedSetDefaultTariffResponse(String id, SetDefaultTariffResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedSetDefaultTariffResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends SetDefaultTariffAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetDefaultTariffResponse receivedSetDefaultTariffRequest(String id, SetDefaultTariffRequest req){
                logger.info(String.format("\n\n\treceivedSetDefaultTariffRequest(%s)\n", id));
                return SetDefaultTariffResponse.builder().build();
            }

            public void sendSetDefaultTariffResponse(String id, SetDefaultTariffResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendSetDefaultTariffResponse(%s)\n", id), err);
            }
        };
    }
}