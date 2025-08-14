package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.ChangeConfigurationOffer;
import io.u2ware.ocpp.v1_6.actions.ChangeConfigurationAnswer;
import io.u2ware.ocpp.v1_6.model.ChangeConfigurationRequest;
import io.u2ware.ocpp.v1_6.model.ChangeConfigurationResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface ChangeConfiguration {

    public interface CentralSystemHandler extends ChangeConfigurationOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ChangeConfigurationRequest sendChangeConfigurationRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendChangeConfigurationRequest(%s)\n", id));
                return ChangeConfigurationRequest.builder().build();
            }

            public void receivedChangeConfigurationResponse(String id, ChangeConfigurationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedChangeConfigurationResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargePointHandler extends ChangeConfigurationAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ChangeConfigurationResponse receivedChangeConfigurationRequest(String id, ChangeConfigurationRequest req){
                logger.info(String.format("\n\n\treceivedChangeConfigurationRequest(%s)\n", id));
                return ChangeConfigurationResponse.builder().build();
            }

            public void sendChangeConfigurationResponse(String id, ChangeConfigurationResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendChangeConfigurationResponse(%s)\n", id), err);
            }
        };
    }
}