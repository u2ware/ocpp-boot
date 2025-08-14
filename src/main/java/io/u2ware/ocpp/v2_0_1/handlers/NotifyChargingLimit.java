package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.NotifyChargingLimitOffer;
import io.u2ware.ocpp.v2_0_1.actions.NotifyChargingLimitAnswer;
import io.u2ware.ocpp.v2_0_1.model.NotifyChargingLimitRequest;
import io.u2ware.ocpp.v2_0_1.model.NotifyChargingLimitResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface NotifyChargingLimit {

    public interface ChargingStationHandler extends NotifyChargingLimitOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyChargingLimitRequest sendNotifyChargingLimitRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyChargingLimitRequest(%s)\n", id));
                return NotifyChargingLimitRequest.builder().build();
            }

            public void receivedNotifyChargingLimitResponse(String id, NotifyChargingLimitResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyChargingLimitResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifyChargingLimitAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyChargingLimitResponse receivedNotifyChargingLimitRequest(String id, NotifyChargingLimitRequest req){
                logger.info(String.format("\n\n\treceivedNotifyChargingLimitRequest(%s)\n", id));
                return NotifyChargingLimitResponse.builder().build();
            }

            public void sendNotifyChargingLimitResponse(String id, NotifyChargingLimitResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyChargingLimitResponse(%s)\n", id), err);
            }
        };
    }
}