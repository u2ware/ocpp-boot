package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.DeleteCertificateOffer;
import io.u2ware.ocpp.v2_1.actions.DeleteCertificateAnswer;
import io.u2ware.ocpp.v2_1.model.DeleteCertificateRequest;
import io.u2ware.ocpp.v2_1.model.DeleteCertificateResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface DeleteCertificate {

    public interface CSMSHandler extends DeleteCertificateOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public DeleteCertificateRequest sendDeleteCertificateRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendDeleteCertificateRequest(%s)\n", id));
                return DeleteCertificateRequest.builder().build();
            }

            public void receivedDeleteCertificateResponse(String id, DeleteCertificateResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedDeleteCertificateResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends DeleteCertificateAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public DeleteCertificateResponse receivedDeleteCertificateRequest(String id, DeleteCertificateRequest req){
                logger.info(String.format("\n\n\treceivedDeleteCertificateRequest(%s)\n", id));
                return DeleteCertificateResponse.builder().build();
            }

            public void sendDeleteCertificateResponse(String id, DeleteCertificateResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendDeleteCertificateResponse(%s)\n", id), err);
            }
        };
    }
}