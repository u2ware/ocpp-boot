package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.SetMonitoringBaseOffer;
import io.u2ware.ocpp.v2_0_1.actions.SetMonitoringBaseAnswer;
import io.u2ware.ocpp.v2_0_1.model.SetMonitoringBaseRequest;
import io.u2ware.ocpp.v2_0_1.model.SetMonitoringBaseResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface SetMonitoringBase {

    public interface CSMSHandler extends SetMonitoringBaseOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetMonitoringBaseRequest sendSetMonitoringBaseRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendSetMonitoringBaseRequest(%s)\n", id));
                return SetMonitoringBaseRequest.builder().build();
            }

            public void receivedSetMonitoringBaseResponse(String id, SetMonitoringBaseResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedSetMonitoringBaseResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends SetMonitoringBaseAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetMonitoringBaseResponse receivedSetMonitoringBaseRequest(String id, SetMonitoringBaseRequest req){
                logger.info(String.format("\n\n\treceivedSetMonitoringBaseRequest(%s)\n", id));
                return SetMonitoringBaseResponse.builder().build();
            }

            public void sendSetMonitoringBaseResponse(String id, SetMonitoringBaseResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendSetMonitoringBaseResponse(%s)\n", id), err);
            }
        };
    }
}