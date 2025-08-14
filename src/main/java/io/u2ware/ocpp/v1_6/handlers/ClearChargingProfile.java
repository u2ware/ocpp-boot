package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.ClearChargingProfileOffer;
import io.u2ware.ocpp.v1_6.actions.ClearChargingProfileAnswer;
import io.u2ware.ocpp.v1_6.model.ClearChargingProfileRequest;
import io.u2ware.ocpp.v1_6.model.ClearChargingProfileResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface ClearChargingProfile {

    public interface CentralSystemHandler extends ClearChargingProfileOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearChargingProfileRequest sendClearChargingProfileRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendClearChargingProfileRequest(%s)\n", id));
                return ClearChargingProfileRequest.builder().build();
            }

            public void receivedClearChargingProfileResponse(String id, ClearChargingProfileResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedClearChargingProfileResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargePointHandler extends ClearChargingProfileAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearChargingProfileResponse receivedClearChargingProfileRequest(String id, ClearChargingProfileRequest req){
                logger.info(String.format("\n\n\treceivedClearChargingProfileRequest(%s)\n", id));
                return ClearChargingProfileResponse.builder().build();
            }

            public void sendClearChargingProfileResponse(String id, ClearChargingProfileResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendClearChargingProfileResponse(%s)\n", id), err);
            }
        };
    }
}