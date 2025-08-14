package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetCertificateStatusOffer;
import io.u2ware.ocpp.v2_1.actions.GetCertificateStatusAnswer;
import io.u2ware.ocpp.v2_1.model.GetCertificateStatusRequest;
import io.u2ware.ocpp.v2_1.model.GetCertificateStatusResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetCertificateStatus {

    public interface ChargingStationHandler extends GetCertificateStatusOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetCertificateStatusRequest sendGetCertificateStatusRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetCertificateStatusRequest(%s)\n", id));
                return GetCertificateStatusRequest.builder().build();
            }

            public void receivedGetCertificateStatusResponse(String id, GetCertificateStatusResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetCertificateStatusResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends GetCertificateStatusAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetCertificateStatusResponse receivedGetCertificateStatusRequest(String id, GetCertificateStatusRequest req){
                logger.info(String.format("\n\n\treceivedGetCertificateStatusRequest(%s)\n", id));
                return GetCertificateStatusResponse.builder().build();
            }

            public void sendGetCertificateStatusResponse(String id, GetCertificateStatusResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetCertificateStatusResponse(%s)\n", id), err);
            }
        };
    }
}