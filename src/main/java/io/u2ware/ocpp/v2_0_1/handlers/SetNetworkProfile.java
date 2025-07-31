package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.SetNetworkProfileOffer;
import io.u2ware.ocpp.v2_0_1.actions.SetNetworkProfileAnswer;
import io.u2ware.ocpp.v2_0_1.model.SetNetworkProfileRequest;
import io.u2ware.ocpp.v2_0_1.model.SetNetworkProfileResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface SetNetworkProfile {

    public interface CSMSHandler extends SetNetworkProfileOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"SetNetworkProfile"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetNetworkProfileRequest sendSetNetworkProfileRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendSetNetworkProfileRequest(%s)\n", id));
                return SetNetworkProfileRequest.builder().build();
            }

            public void receivedSetNetworkProfileResponse(String id, SetNetworkProfileResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedSetNetworkProfileResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends SetNetworkProfileAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"SetNetworkProfile"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetNetworkProfileResponse receivedSetNetworkProfileRequest(String id, SetNetworkProfileRequest req){
                logger.info(String.format("\n\n\treceivedSetNetworkProfileRequest(%s)\n", id));
                return SetNetworkProfileResponse.builder().build();
            }

            public void sendSetNetworkProfileResponse(String id, SetNetworkProfileResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendSetNetworkProfileResponse(%s)\n", id), err);
            }
        };
    }
}