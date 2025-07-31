package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.AuthorizeOffer;
import io.u2ware.ocpp.v1_6.actions.AuthorizeAnswer;
import io.u2ware.ocpp.v1_6.model.AuthorizeRequest;
import io.u2ware.ocpp.v1_6.model.AuthorizeResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface Authorize {

    public interface ChargePointHandler extends AuthorizeOffer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {

        default String[] features() { return new String[]{"Authorize"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

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

    public interface CentralSystemHandler extends AuthorizeAnswer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {    

        default String[] features() { return new String[]{"Authorize"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

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