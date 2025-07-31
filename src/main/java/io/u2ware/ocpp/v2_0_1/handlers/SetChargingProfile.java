package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.SetChargingProfileOffer;
import io.u2ware.ocpp.v2_0_1.actions.SetChargingProfileAnswer;
import io.u2ware.ocpp.v2_0_1.model.SetChargingProfileRequest;
import io.u2ware.ocpp.v2_0_1.model.SetChargingProfileResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface SetChargingProfile {

    public interface CSMSHandler extends SetChargingProfileOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"SetChargingProfile"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

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

    public interface ChargingStationHandler extends SetChargingProfileAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"SetChargingProfile"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

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