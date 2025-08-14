package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.SignCertificateOffer;
import io.u2ware.ocpp.v2_0_1.actions.SignCertificateAnswer;
import io.u2ware.ocpp.v2_0_1.model.SignCertificateRequest;
import io.u2ware.ocpp.v2_0_1.model.SignCertificateResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface SignCertificate {

    public interface ChargingStationHandler extends SignCertificateOffer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SignCertificateRequest sendSignCertificateRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendSignCertificateRequest(%s)\n", id));
                return SignCertificateRequest.builder().build();
            }

            public void receivedSignCertificateResponse(String id, SignCertificateResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedSignCertificateResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends SignCertificateAnswer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public SignCertificateResponse receivedSignCertificateRequest(String id, SignCertificateRequest req){
                logger.info(String.format("\n\n\treceivedSignCertificateRequest(%s)\n", id));
                return SignCertificateResponse.builder().build();
            }

            public void sendSignCertificateResponse(String id, SignCertificateResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendSignCertificateResponse(%s)\n", id), err);
            }
        };
    }
}