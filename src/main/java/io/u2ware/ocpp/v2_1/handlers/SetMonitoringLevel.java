package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.SetMonitoringLevelOffer;
import io.u2ware.ocpp.v2_1.actions.SetMonitoringLevelAnswer;
import io.u2ware.ocpp.v2_1.model.SetMonitoringLevelRequest;
import io.u2ware.ocpp.v2_1.model.SetMonitoringLevelResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SetMonitoringLevel {

    public interface CSMSHandler extends SetMonitoringLevelOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetMonitoringLevelRequest sendSetMonitoringLevelRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendSetMonitoringLevelRequest(%s)\n", id));
                return SetMonitoringLevelRequest.builder().build();
            }

            public void receivedSetMonitoringLevelResponse(String id, SetMonitoringLevelResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedSetMonitoringLevelResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends SetMonitoringLevelAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetMonitoringLevelResponse receivedSetMonitoringLevelRequest(String id, SetMonitoringLevelRequest req){
                logger.info(String.format("\n\n\treceivedSetMonitoringLevelRequest(%s)\n", id));
                return SetMonitoringLevelResponse.builder().build();
            }

            public void sendSetMonitoringLevelResponse(String id, SetMonitoringLevelResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendSetMonitoringLevelResponse(%s)\n", id), err);
            }
        };
    }
}