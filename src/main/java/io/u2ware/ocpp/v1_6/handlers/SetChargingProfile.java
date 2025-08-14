package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.SetChargingProfileOffer;
import io.u2ware.ocpp.v1_6.actions.SetChargingProfileAnswer;
import io.u2ware.ocpp.v1_6.model.SetChargingProfileRequest;
import io.u2ware.ocpp.v1_6.model.SetChargingProfileResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface SetChargingProfile {

    public interface CentralSystemHandler extends SetChargingProfileOffer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetChargingProfileRequest sendSetChargingProfileRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendSetChargingProfileRequest(%s)\n", id));
                return SetChargingProfileRequest.builder().build();
            }

            public void receivedSetChargingProfileResponse(String id, SetChargingProfileResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedSetChargingProfileResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargePointHandler extends SetChargingProfileAnswer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {    

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetChargingProfileResponse receivedSetChargingProfileRequest(String id, SetChargingProfileRequest req){
                logger.info(String.format("\n\n\treceivedSetChargingProfileRequest(%s)\n", id));
                return SetChargingProfileResponse.builder().build();
            }

            public void sendSetChargingProfileResponse(String id, SetChargingProfileResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendSetChargingProfileResponse(%s)\n", id), err);
            }
        };
    }
}