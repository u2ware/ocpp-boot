package io.u2ware.ocpp.v1_6.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v1_6.actions.MeterValuesOffer;
import io.u2ware.ocpp.v1_6.actions.MeterValuesAnswer;
import io.u2ware.ocpp.v1_6.model.MeterValuesRequest;
import io.u2ware.ocpp.v1_6.model.MeterValuesResponse;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;

public interface MeterValues {

    public interface ChargePointHandler extends MeterValuesOffer, io.u2ware.ocpp.v1_6.messaging.ChargePointHandler {

        default String[] features() { return new String[]{"MeterValues"};}

        public static ChargePointHandler DEFAULT = new ChargePointHandler(){

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

    public interface CentralSystemHandler extends MeterValuesAnswer, io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler {    

        default String[] features() { return new String[]{"MeterValues"};}

        public static CentralSystemHandler DEFAULT = new CentralSystemHandler(){

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