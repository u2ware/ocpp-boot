package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.NotifyDisplayMessagesOffer;
import io.u2ware.ocpp.v2_1.actions.NotifyDisplayMessagesAnswer;
import io.u2ware.ocpp.v2_1.model.NotifyDisplayMessagesRequest;
import io.u2ware.ocpp.v2_1.model.NotifyDisplayMessagesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyDisplayMessages {

    public interface ChargingStationHandler extends NotifyDisplayMessagesOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyDisplayMessagesRequest sendNotifyDisplayMessagesRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyDisplayMessagesRequest(%s)\n", id));
                return NotifyDisplayMessagesRequest.builder().build();
            }

            public void receivedNotifyDisplayMessagesResponse(String id, NotifyDisplayMessagesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyDisplayMessagesResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends NotifyDisplayMessagesAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyDisplayMessagesResponse receivedNotifyDisplayMessagesRequest(String id, NotifyDisplayMessagesRequest req){
                logger.info(String.format("\n\n\treceivedNotifyDisplayMessagesRequest(%s)\n", id));
                return NotifyDisplayMessagesResponse.builder().build();
            }

            public void sendNotifyDisplayMessagesResponse(String id, NotifyDisplayMessagesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyDisplayMessagesResponse(%s)\n", id), err);
            }
        };
    }
}