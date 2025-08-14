package io.u2ware.ocpp.v2_0_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_0_1.actions.CertificateSignedOffer;
import io.u2ware.ocpp.v2_0_1.actions.CertificateSignedAnswer;
import io.u2ware.ocpp.v2_0_1.model.CertificateSignedRequest;
import io.u2ware.ocpp.v2_0_1.model.CertificateSignedResponse;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;

public interface CertificateSigned {

    public interface CSMSHandler extends CertificateSignedOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public CertificateSignedRequest sendCertificateSignedRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendCertificateSignedRequest(%s)\n", id));
                return CertificateSignedRequest.builder().build();
            }

            public void receivedCertificateSignedResponse(String id, CertificateSignedResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedCertificateSignedResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends CertificateSignedAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public CertificateSignedResponse receivedCertificateSignedRequest(String id, CertificateSignedRequest req){
                logger.info(String.format("\n\n\treceivedCertificateSignedRequest(%s)\n", id));
                return CertificateSignedResponse.builder().build();
            }

            public void sendCertificateSignedResponse(String id, CertificateSignedResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendCertificateSignedResponse(%s)\n", id), err);
            }
        };
    }
}