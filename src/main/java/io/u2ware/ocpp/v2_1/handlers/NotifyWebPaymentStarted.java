package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.NotifyWebPaymentStartedOffer;
import io.u2ware.ocpp.v2_1.actions.NotifyWebPaymentStartedAnswer;
import io.u2ware.ocpp.v2_1.model.NotifyWebPaymentStartedRequest;
import io.u2ware.ocpp.v2_1.model.NotifyWebPaymentStartedResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyWebPaymentStarted {

    public interface CSMSHandler extends NotifyWebPaymentStartedOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyWebPaymentStartedRequest sendNotifyWebPaymentStartedRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendNotifyWebPaymentStartedRequest(%s)\n", id));
                return NotifyWebPaymentStartedRequest.builder().build();
            }

            public void receivedNotifyWebPaymentStartedResponse(String id, NotifyWebPaymentStartedResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedNotifyWebPaymentStartedResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends NotifyWebPaymentStartedAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public NotifyWebPaymentStartedResponse receivedNotifyWebPaymentStartedRequest(String id, NotifyWebPaymentStartedRequest req){
                logger.info(String.format("\n\n\treceivedNotifyWebPaymentStartedRequest(%s)\n", id));
                return NotifyWebPaymentStartedResponse.builder().build();
            }

            public void sendNotifyWebPaymentStartedResponse(String id, NotifyWebPaymentStartedResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendNotifyWebPaymentStartedResponse(%s)\n", id), err);
            }
        };
    }
}