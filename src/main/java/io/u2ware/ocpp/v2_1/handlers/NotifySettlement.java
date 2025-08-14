package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.NotifySettlementOffer;
import io.u2ware.ocpp.v2_1.actions.NotifySettlementAnswer;
import io.u2ware.ocpp.v2_1.model.NotifySettlementRequest;
import io.u2ware.ocpp.v2_1.model.NotifySettlementResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifySettlement {

    public interface ChargingStationHandler extends NotifySettlementOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifySettlementRequest sendNotifySettlementRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifySettlementRequest(%s)\n", id));
                return NotifySettlementRequest.builder().build();
            }

            public void receivedNotifySettlementResponse(String id, NotifySettlementResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifySettlementResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifySettlementAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifySettlementResponse receivedNotifySettlementRequest(String id, NotifySettlementRequest req){
                logger.info(String.format("\n\n\treceivedNotifySettlementRequest(%s)\n", id));
                return NotifySettlementResponse.builder().build();
            }

            public void sendNotifySettlementResponse(String id, NotifySettlementResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifySettlementResponse(%s)\n", id), err);
            }
        };
    }
}