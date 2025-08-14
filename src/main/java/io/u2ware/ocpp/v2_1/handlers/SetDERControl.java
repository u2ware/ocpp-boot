package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.SetDERControlOffer;
import io.u2ware.ocpp.v2_1.actions.SetDERControlAnswer;
import io.u2ware.ocpp.v2_1.model.SetDERControlRequest;
import io.u2ware.ocpp.v2_1.model.SetDERControlResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SetDERControl {

    public interface CSMSHandler extends SetDERControlOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetDERControlRequest sendSetDERControlRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendSetDERControlRequest(%s)\n", id));
                return SetDERControlRequest.builder().build();
            }

            public void receivedSetDERControlResponse(String id, SetDERControlResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedSetDERControlResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends SetDERControlAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SetDERControlResponse receivedSetDERControlRequest(String id, SetDERControlRequest req){
                logger.info(String.format("\n\n\treceivedSetDERControlRequest(%s)\n", id));
                return SetDERControlResponse.builder().build();
            }

            public void sendSetDERControlResponse(String id, SetDERControlResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendSetDERControlResponse(%s)\n", id), err);
            }
        };
    }
}