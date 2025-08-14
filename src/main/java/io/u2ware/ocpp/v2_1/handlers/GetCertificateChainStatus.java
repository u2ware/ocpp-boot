package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetCertificateChainStatusOffer;
import io.u2ware.ocpp.v2_1.actions.GetCertificateChainStatusAnswer;
import io.u2ware.ocpp.v2_1.model.GetCertificateChainStatusRequest;
import io.u2ware.ocpp.v2_1.model.GetCertificateChainStatusResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetCertificateChainStatus {

    public interface ChargingStationHandler extends GetCertificateChainStatusOffer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetCertificateChainStatusRequest sendGetCertificateChainStatusRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetCertificateChainStatusRequest(%s)\n", id));
                return GetCertificateChainStatusRequest.builder().build();
            }

            public void receivedGetCertificateChainStatusResponse(String id, GetCertificateChainStatusResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetCertificateChainStatusResponse(%s)\n", id), err);
            }
        };
    }

    public interface CSMSHandler extends GetCertificateChainStatusAnswer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {    

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetCertificateChainStatusResponse receivedGetCertificateChainStatusRequest(String id, GetCertificateChainStatusRequest req){
                logger.info(String.format("\n\n\treceivedGetCertificateChainStatusRequest(%s)\n", id));
                return GetCertificateChainStatusResponse.builder().build();
            }

            public void sendGetCertificateChainStatusResponse(String id, GetCertificateChainStatusResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetCertificateChainStatusResponse(%s)\n", id), err);
            }
        };
    }
}