package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.MeterValuesOffer;
import io.u2ware.ocpp.v2_0_1.actions.MeterValuesAnswer;
import io.u2ware.ocpp.v2_0_1.model.MeterValuesRequest;
import io.u2ware.ocpp.v2_0_1.model.MeterValuesResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface MeterValues {

    public interface ChargingStationHandler extends MeterValuesOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        default String[] features() { return new String[]{"MeterValues"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public MeterValuesRequest sendMeterValuesRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendMeterValuesRequest(%s)\n", id));
                return MeterValuesRequest.builder().build();
            }

            public void receivedMeterValuesResponse(String id, MeterValuesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedMeterValuesResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends MeterValuesAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        default String[] features() { return new String[]{"MeterValues"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public MeterValuesResponse receivedMeterValuesRequest(String id, MeterValuesRequest req){
                logger.info(String.format("\n\n\treceivedMeterValuesRequest(%s)\n", id));
                return MeterValuesResponse.builder().build();
            }

            public void sendMeterValuesResponse(String id, MeterValuesResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendMeterValuesResponse(%s)\n", id), err);
            }
        };
    }
}