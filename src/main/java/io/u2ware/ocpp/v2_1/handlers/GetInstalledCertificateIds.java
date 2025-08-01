package io.u2ware.ocpp.v2_1.handlers;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import io.u2ware.ocpp.v2_1.actions.GetInstalledCertificateIdsOffer;
import io.u2ware.ocpp.v2_1.actions.GetInstalledCertificateIdsAnswer;
import io.u2ware.ocpp.v2_1.model.GetInstalledCertificateIdsRequest;
import io.u2ware.ocpp.v2_1.model.GetInstalledCertificateIdsResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface GetInstalledCertificateIds {

    public interface CSMSHandler extends GetInstalledCertificateIdsOffer, io.u2ware.ocpp.v2_1.messaging.CSMSHandler {

        default String[] features() { return new String[]{"GetInstalledCertificateIds"};}

        public static CSMSHandler DEFAULT = new CSMSHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetInstalledCertificateIdsRequest sendGetInstalledCertificateIdsRequest(String id, Map<String,Object> req){
                logger.info(String.format("\n\n\tsendGetInstalledCertificateIdsRequest(%s)\n", id));
                return GetInstalledCertificateIdsRequest.builder().build();
            }

            public void receivedGetInstalledCertificateIdsResponse(String id, GetInstalledCertificateIdsResponse res, ErrorCode err){
                logger.info(String.format("\n\n\treceivedGetInstalledCertificateIdsResponse(%s)\n", id), err);
            }
        };
    }

    public interface ChargingStationHandler extends GetInstalledCertificateIdsAnswer, io.u2ware.ocpp.v2_1.messaging.ChargingStationHandler {    

        default String[] features() { return new String[]{"GetInstalledCertificateIds"};}

        public static ChargingStationHandler DEFAULT = new ChargingStationHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            public GetInstalledCertificateIdsResponse receivedGetInstalledCertificateIdsRequest(String id, GetInstalledCertificateIdsRequest req){
                logger.info(String.format("\n\n\treceivedGetInstalledCertificateIdsRequest(%s)\n", id));
                return GetInstalledCertificateIdsResponse.builder().build();
            }

            public void sendGetInstalledCertificateIdsResponse(String id, GetInstalledCertificateIdsResponse res, ErrorCode err){
                logger.info(String.format("\n\n\tsendGetInstalledCertificateIdsResponse(%s)\n", id), err);
            }
        };
    }
}