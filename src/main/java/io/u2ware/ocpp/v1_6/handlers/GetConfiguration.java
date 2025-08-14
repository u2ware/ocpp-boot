package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.GetConfigurationOffer;
import io.u2ware.ocpp.v1_6.actions.GetConfigurationAnswer;
import io.u2ware.ocpp.v1_6.model.GetConfigurationRequest;
import io.u2ware.ocpp.v1_6.model.GetConfigurationResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface GetConfiguration {

    public interface CentralSystemHandler extends GetConfigurationOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetConfigurationRequest sendGetConfigurationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetConfigurationRequest(%s)\n", id));
                return GetConfigurationRequest.builder().build();
            }

            public void receivedGetConfigurationResponse(String id, GetConfigurationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetConfigurationResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargePointHandler extends GetConfigurationAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetConfigurationResponse receivedGetConfigurationRequest(String id, GetConfigurationRequest req){
                logger.info(String.format("\n\n\treceivedGetConfigurationRequest(%s)\n", id));
                return GetConfigurationResponse.builder().build();
            }

            public void sendGetConfigurationResponse(String id, GetConfigurationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetConfigurationResponse(%s)\n", id), err);
            }
        };
    }
}