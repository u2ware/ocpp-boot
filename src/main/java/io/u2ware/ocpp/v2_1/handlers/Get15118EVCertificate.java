package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.Get15118EVCertificateOffer;
import io.u2ware.ocpp.v2_1.actions.Get15118EVCertificateAnswer;
import io.u2ware.ocpp.v2_1.model.Get15118EVCertificateRequest;
import io.u2ware.ocpp.v2_1.model.Get15118EVCertificateResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface Get15118EVCertificate {

    public interface ChargingStationHandler extends Get15118EVCertificateOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public Get15118EVCertificateRequest sendGet15118EVCertificateRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGet15118EVCertificateRequest(%s)\n", id));
                return Get15118EVCertificateRequest.builder().build();
            }

            public void receivedGet15118EVCertificateResponse(String id, Get15118EVCertificateResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGet15118EVCertificateResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends Get15118EVCertificateAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public Get15118EVCertificateResponse receivedGet15118EVCertificateRequest(String id, Get15118EVCertificateRequest req){
                logger.info(String.format("\n\n\treceivedGet15118EVCertificateRequest(%s)\n", id));
                return Get15118EVCertificateResponse.builder().build();
            }

            public void sendGet15118EVCertificateResponse(String id, Get15118EVCertificateResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGet15118EVCertificateResponse(%s)\n", id), err);
            }
        };
    }
}