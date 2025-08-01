package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetChargingProfilesOffer;
import io.u2ware.ocpp.v2_1.actions.GetChargingProfilesAnswer;
import io.u2ware.ocpp.v2_1.model.GetChargingProfilesRequest;
import io.u2ware.ocpp.v2_1.model.GetChargingProfilesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetChargingProfiles {

    public interface ChargingStationHandler extends GetChargingProfilesOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"GetChargingProfiles"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetChargingProfilesRequest sendGetChargingProfilesRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetChargingProfilesRequest(%s)\n", id));
                return GetChargingProfilesRequest.builder().build();
            }

            public void receivedGetChargingProfilesResponse(String id, GetChargingProfilesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetChargingProfilesResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends GetChargingProfilesAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"GetChargingProfiles"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetChargingProfilesResponse receivedGetChargingProfilesRequest(String id, GetChargingProfilesRequest req){
                logger.info(String.format("\n\n\treceivedGetChargingProfilesRequest(%s)\n", id));
                return GetChargingProfilesResponse.builder().build();
            }

            public void sendGetChargingProfilesResponse(String id, GetChargingProfilesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetChargingProfilesResponse(%s)\n", id), err);
            }
        };
    }
}