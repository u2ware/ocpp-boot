package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetDisplayMessagesOffer;
import io.u2ware.ocpp.v2_1.actions.GetDisplayMessagesAnswer;
import io.u2ware.ocpp.v2_1.model.GetDisplayMessagesRequest;
import io.u2ware.ocpp.v2_1.model.GetDisplayMessagesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetDisplayMessages {

    public interface CSMSHandler extends GetDisplayMessagesOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"GetDisplayMessages"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetDisplayMessagesRequest sendGetDisplayMessagesRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetDisplayMessagesRequest(%s)\n", id));
                return GetDisplayMessagesRequest.builder().build();
            }

            public void receivedGetDisplayMessagesResponse(String id, GetDisplayMessagesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetDisplayMessagesResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends GetDisplayMessagesAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"GetDisplayMessages"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetDisplayMessagesResponse receivedGetDisplayMessagesRequest(String id, GetDisplayMessagesRequest req){
                logger.info(String.format("\n\n\treceivedGetDisplayMessagesRequest(%s)\n", id));
                return GetDisplayMessagesResponse.builder().build();
            }

            public void sendGetDisplayMessagesResponse(String id, GetDisplayMessagesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetDisplayMessagesResponse(%s)\n", id), err);
            }
        };
    }
}