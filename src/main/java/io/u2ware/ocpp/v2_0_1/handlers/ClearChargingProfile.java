package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.ClearChargingProfileOffer;
import io.u2ware.ocpp.v2_0_1.actions.ClearChargingProfileAnswer;
import io.u2ware.ocpp.v2_0_1.model.ClearChargingProfileRequest;
import io.u2ware.ocpp.v2_0_1.model.ClearChargingProfileResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface ClearChargingProfile {

    public interface CSMSHandler extends ClearChargingProfileOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

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

    public interface ChargingStationHandler extends ClearChargingProfileAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

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