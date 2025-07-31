package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.AuthorizeOffer;
import io.u2ware.ocpp.v2_0_1.actions.AuthorizeAnswer;
import io.u2ware.ocpp.v2_0_1.model.AuthorizeRequest;
import io.u2ware.ocpp.v2_0_1.model.AuthorizeResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface Authorize {

    public interface ChargingStationHandler extends AuthorizeOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"Authorize"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public AuthorizeRequest sendAuthorizeRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendAuthorizeRequest(%s)\n", id));
                return AuthorizeRequest.builder().build();
            }

            public void receivedAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedAuthorizeResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends AuthorizeAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"Authorize"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public AuthorizeResponse receivedAuthorizeRequest(String id, AuthorizeRequest req){
                logger.info(String.format("\n\n\treceivedAuthorizeRequest(%s)\n", id));
                return AuthorizeResponse.builder().build();
            }

            public void sendAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendAuthorizeResponse(%s)\n", id), err);
            }
        };
    }
}