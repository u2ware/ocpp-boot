package io.u2ware.ocpp.v2_0_1.handlers;

import io.u2ware.ocpp.v2_0_1.actions.CertificateSignedAnswer;
import io.u2ware.ocpp.v2_0_1.actions.CertificateSignedOffer;
import io.u2ware.ocpp.v2_0_1.actions.SignCertificateAnswer;
import io.u2ware.ocpp.v2_0_1.actions.SignCertificateOffer;

public interface A03 {
    
    public interface ChargingStationFeature extends SignCertificateOffer, CertificateSignedAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler{

        default String[] name() { return new String[]{"A03"};}
    }

    public interface CSMSFeature extends A03, SignCertificateAnswer, CertificateSignedOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler {

        default String[] name() { return new String[]{"A03"};}

    }

}
