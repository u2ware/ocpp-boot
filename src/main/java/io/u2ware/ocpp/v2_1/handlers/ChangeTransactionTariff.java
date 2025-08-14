package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.ChangeTransactionTariffOffer;
import io.u2ware.ocpp.v2_1.actions.ChangeTransactionTariffAnswer;
import io.u2ware.ocpp.v2_1.model.ChangeTransactionTariffRequest;
import io.u2ware.ocpp.v2_1.model.ChangeTransactionTariffResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ChangeTransactionTariff {

    public interface CSMSHandler extends ChangeTransactionTariffOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ChangeTransactionTariffRequest sendChangeTransactionTariffRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendChangeTransactionTariffRequest(%s)\n", id));
                return ChangeTransactionTariffRequest.builder().build();
            }

            public void receivedChangeTransactionTariffResponse(String id, ChangeTransactionTariffResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedChangeTransactionTariffResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends ChangeTransactionTariffAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ChangeTransactionTariffResponse receivedChangeTransactionTariffRequest(String id, ChangeTransactionTariffRequest req){
                logger.info(String.format("\n\n\treceivedChangeTransactionTariffRequest(%s)\n", id));
                return ChangeTransactionTariffResponse.builder().build();
            }

            public void sendChangeTransactionTariffResponse(String id, ChangeTransactionTariffResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendChangeTransactionTariffResponse(%s)\n", id), err);
            }
        };
    }
}