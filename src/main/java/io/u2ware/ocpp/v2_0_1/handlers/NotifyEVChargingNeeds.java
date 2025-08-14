package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.NotifyEVChargingNeedsOffer;
import io.u2ware.ocpp.v2_0_1.actions.NotifyEVChargingNeedsAnswer;
import io.u2ware.ocpp.v2_0_1.model.NotifyEVChargingNeedsRequest;
import io.u2ware.ocpp.v2_0_1.model.NotifyEVChargingNeedsResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface NotifyEVChargingNeeds {

    public interface ChargingStationHandler extends NotifyEVChargingNeedsOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyEVChargingNeedsRequest sendNotifyEVChargingNeedsRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyEVChargingNeedsRequest(%s)\n", id));
                return NotifyEVChargingNeedsRequest.builder().build();
            }

            public void receivedNotifyEVChargingNeedsResponse(String id, NotifyEVChargingNeedsResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyEVChargingNeedsResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifyEVChargingNeedsAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyEVChargingNeedsResponse receivedNotifyEVChargingNeedsRequest(String id, NotifyEVChargingNeedsRequest req){
                logger.info(String.format("\n\n\treceivedNotifyEVChargingNeedsRequest(%s)\n", id));
                return NotifyEVChargingNeedsResponse.builder().build();
            }

            public void sendNotifyEVChargingNeedsResponse(String id, NotifyEVChargingNeedsResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyEVChargingNeedsResponse(%s)\n", id), err);
            }
        };
    }
}