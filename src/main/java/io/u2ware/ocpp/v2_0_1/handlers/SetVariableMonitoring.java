package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.SetVariableMonitoringOffer;
import io.u2ware.ocpp.v2_0_1.actions.SetVariableMonitoringAnswer;
import io.u2ware.ocpp.v2_0_1.model.SetVariableMonitoringRequest;
import io.u2ware.ocpp.v2_0_1.model.SetVariableMonitoringResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface SetVariableMonitoring {

    public interface CSMSHandler extends SetVariableMonitoringOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetVariableMonitoringRequest sendSetVariableMonitoringRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendSetVariableMonitoringRequest(%s)\n", id));
                return SetVariableMonitoringRequest.builder().build();
            }

            public void receivedSetVariableMonitoringResponse(String id, SetVariableMonitoringResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedSetVariableMonitoringResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends SetVariableMonitoringAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetVariableMonitoringResponse receivedSetVariableMonitoringRequest(String id, SetVariableMonitoringRequest req){
                logger.info(String.format("\n\n\treceivedSetVariableMonitoringRequest(%s)\n", id));
                return SetVariableMonitoringResponse.builder().build();
            }

            public void sendSetVariableMonitoringResponse(String id, SetVariableMonitoringResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendSetVariableMonitoringResponse(%s)\n", id), err);
            }
        };
    }
}