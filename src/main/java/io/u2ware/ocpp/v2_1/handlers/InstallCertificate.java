package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.InstallCertificateOffer;
import io.u2ware.ocpp.v2_1.actions.InstallCertificateAnswer;
import io.u2ware.ocpp.v2_1.model.InstallCertificateRequest;
import io.u2ware.ocpp.v2_1.model.InstallCertificateResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface InstallCertificate {

    public interface CSMSHandler extends InstallCertificateOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public InstallCertificateRequest sendInstallCertificateRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendInstallCertificateRequest(%s)\n", id));
                return InstallCertificateRequest.builder().build();
            }

            public void receivedInstallCertificateResponse(String id, InstallCertificateResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedInstallCertificateResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends InstallCertificateAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public InstallCertificateResponse receivedInstallCertificateRequest(String id, InstallCertificateRequest req){
                logger.info(String.format("\n\n\treceivedInstallCertificateRequest(%s)\n", id));
                return InstallCertificateResponse.builder().build();
            }

            public void sendInstallCertificateResponse(String id, InstallCertificateResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendInstallCertificateResponse(%s)\n", id), err);
            }
        };
    }
}