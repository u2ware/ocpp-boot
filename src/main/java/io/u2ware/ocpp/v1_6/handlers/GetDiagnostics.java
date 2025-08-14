package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.GetDiagnosticsOffer;
import io.u2ware.ocpp.v1_6.actions.GetDiagnosticsAnswer;
import io.u2ware.ocpp.v1_6.model.GetDiagnosticsRequest;
import io.u2ware.ocpp.v1_6.model.GetDiagnosticsResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface GetDiagnostics {

    public interface CentralSystemHandler extends GetDiagnosticsOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetDiagnosticsRequest sendGetDiagnosticsRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetDiagnosticsRequest(%s)\n", id));
                return GetDiagnosticsRequest.builder().build();
            }

            public void receivedGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetDiagnosticsResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargePointHandler extends GetDiagnosticsAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetDiagnosticsResponse receivedGetDiagnosticsRequest(String id, GetDiagnosticsRequest req){
                logger.info(String.format("\n\n\treceivedGetDiagnosticsRequest(%s)\n", id));
                return GetDiagnosticsResponse.builder().build();
            }

            public void sendGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetDiagnosticsResponse(%s)\n", id), err);
            }
        };
    }
}