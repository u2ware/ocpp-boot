package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.NotifyPriorityChargingOffer;
import io.u2ware.ocpp.v2_1.actions.NotifyPriorityChargingAnswer;
import io.u2ware.ocpp.v2_1.model.NotifyPriorityChargingRequest;
import io.u2ware.ocpp.v2_1.model.NotifyPriorityChargingResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyPriorityCharging {

    public interface ChargingStationHandler extends NotifyPriorityChargingOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyPriorityChargingRequest sendNotifyPriorityChargingRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyPriorityChargingRequest(%s)\n", id));
                return NotifyPriorityChargingRequest.builder().build();
            }

            public void receivedNotifyPriorityChargingResponse(String id, NotifyPriorityChargingResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyPriorityChargingResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifyPriorityChargingAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyPriorityChargingResponse receivedNotifyPriorityChargingRequest(String id, NotifyPriorityChargingRequest req){
                logger.info(String.format("\n\n\treceivedNotifyPriorityChargingRequest(%s)\n", id));
                return NotifyPriorityChargingResponse.builder().build();
            }

            public void sendNotifyPriorityChargingResponse(String id, NotifyPriorityChargingResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyPriorityChargingResponse(%s)\n", id), err);
            }
        };
    }
}