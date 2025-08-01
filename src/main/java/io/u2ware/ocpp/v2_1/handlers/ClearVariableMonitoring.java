package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.ClearVariableMonitoringOffer;
import io.u2ware.ocpp.v2_1.actions.ClearVariableMonitoringAnswer;
import io.u2ware.ocpp.v2_1.model.ClearVariableMonitoringRequest;
import io.u2ware.ocpp.v2_1.model.ClearVariableMonitoringResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ClearVariableMonitoring {

    public interface CSMSHandler extends ClearVariableMonitoringOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"ClearVariableMonitoring"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearVariableMonitoringRequest sendClearVariableMonitoringRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendClearVariableMonitoringRequest(%s)\n", id));
                return ClearVariableMonitoringRequest.builder().build();
            }

            public void receivedClearVariableMonitoringResponse(String id, ClearVariableMonitoringResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedClearVariableMonitoringResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends ClearVariableMonitoringAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"ClearVariableMonitoring"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public ClearVariableMonitoringResponse receivedClearVariableMonitoringRequest(String id, ClearVariableMonitoringRequest req){
                logger.info(String.format("\n\n\treceivedClearVariableMonitoringRequest(%s)\n", id));
                return ClearVariableMonitoringResponse.builder().build();
            }

            public void sendClearVariableMonitoringResponse(String id, ClearVariableMonitoringResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendClearVariableMonitoringResponse(%s)\n", id), err);
            }
        };
    }
}