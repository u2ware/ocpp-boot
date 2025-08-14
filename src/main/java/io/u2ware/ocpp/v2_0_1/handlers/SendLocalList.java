package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.SendLocalListOffer;
import io.u2ware.ocpp.v2_0_1.actions.SendLocalListAnswer;
import io.u2ware.ocpp.v2_0_1.model.SendLocalListRequest;
import io.u2ware.ocpp.v2_0_1.model.SendLocalListResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface SendLocalList {

    public interface CSMSHandler extends SendLocalListOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SendLocalListRequest sendSendLocalListRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendSendLocalListRequest(%s)\n", id));
                return SendLocalListRequest.builder().build();
            }

            public void receivedSendLocalListResponse(String id, SendLocalListResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedSendLocalListResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends SendLocalListAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SendLocalListResponse receivedSendLocalListRequest(String id, SendLocalListRequest req){
                logger.info(String.format("\n\n\treceivedSendLocalListRequest(%s)\n", id));
                return SendLocalListResponse.builder().build();
            }

            public void sendSendLocalListResponse(String id, SendLocalListResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendSendLocalListResponse(%s)\n", id), err);
            }
        };
    }
}