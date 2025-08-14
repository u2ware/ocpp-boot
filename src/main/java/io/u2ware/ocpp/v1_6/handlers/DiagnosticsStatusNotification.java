package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.DiagnosticsStatusNotificationOffer;
import io.u2ware.ocpp.v1_6.actions.DiagnosticsStatusNotificationAnswer;
import io.u2ware.ocpp.v1_6.model.DiagnosticsStatusNotificationRequest;
import io.u2ware.ocpp.v1_6.model.DiagnosticsStatusNotificationResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface DiagnosticsStatusNotification {

    public interface ChargePointHandler extends DiagnosticsStatusNotificationOffer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public DiagnosticsStatusNotificationRequest sendDiagnosticsStatusNotificationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendDiagnosticsStatusNotificationRequest(%s)\n", id));
                return DiagnosticsStatusNotificationRequest.builder().build();
            }

            public void receivedDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedDiagnosticsStatusNotificationResponse(%s)\n", id), err);
            }
        };
    }

    public interface CentralSystemHandler extends DiagnosticsStatusNotificationAnswer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {    

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public DiagnosticsStatusNotificationResponse receivedDiagnosticsStatusNotificationRequest(String id, DiagnosticsStatusNotificationRequest req){
                logger.info(String.format("\n\n\treceivedDiagnosticsStatusNotificationRequest(%s)\n", id));
                return DiagnosticsStatusNotificationResponse.builder().build();
            }

            public void sendDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendDiagnosticsStatusNotificationResponse(%s)\n", id), err);
            }
        };
    }
}