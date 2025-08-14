package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.NotifyAllowedEnergyTransferOffer;
import io.u2ware.ocpp.v2_1.actions.NotifyAllowedEnergyTransferAnswer;
import io.u2ware.ocpp.v2_1.model.NotifyAllowedEnergyTransferRequest;
import io.u2ware.ocpp.v2_1.model.NotifyAllowedEnergyTransferResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyAllowedEnergyTransfer {

    public interface CSMSHandler extends NotifyAllowedEnergyTransferOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyAllowedEnergyTransferRequest sendNotifyAllowedEnergyTransferRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyAllowedEnergyTransferRequest(%s)\n", id));
                return NotifyAllowedEnergyTransferRequest.builder().build();
            }

            public void receivedNotifyAllowedEnergyTransferResponse(String id, NotifyAllowedEnergyTransferResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyAllowedEnergyTransferResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends NotifyAllowedEnergyTransferAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyAllowedEnergyTransferResponse receivedNotifyAllowedEnergyTransferRequest(String id, NotifyAllowedEnergyTransferRequest req){
                logger.info(String.format("\n\n\treceivedNotifyAllowedEnergyTransferRequest(%s)\n", id));
                return NotifyAllowedEnergyTransferResponse.builder().build();
            }

            public void sendNotifyAllowedEnergyTransferResponse(String id, NotifyAllowedEnergyTransferResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyAllowedEnergyTransferResponse(%s)\n", id), err);
            }
        };
    }
}