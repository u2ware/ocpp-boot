package io.u2ware.ocpp.v2_0_1.handlers;

import io.u2ware.ocpp.v2_0_1.actions.CertificateSignedAnswer;
import io.u2ware.ocpp.v2_0_1.actions.CertificateSignedOffer;
import io.u2ware.ocpp.v2_0_1.actions.SignCertificateAnswer;
import io.u2ware.ocpp.v2_0_1.actions.SignCertificateOffer;
import io.u2ware.ocpp.v2_0_1.actions.TriggerMessageAnswer;
import io.u2ware.ocpp.v2_0_1.actions.TriggerMessageOffer;

public interface A02 {

    
    public interface ChargingStationFeature extends TriggerMessageAnswer, SignCertificateOffer, CertificateSignedAnswer, io.u2ware.ocpp.v2_0_1.messaging.ChargingStationHandler{

        default String[] name() { return new String[]{"A02"};}
    }


    public interface CSMSFeature extends TriggerMessageOffer, SignCertificateAnswer, CertificateSignedOffer, io.u2ware.ocpp.v2_0_1.messaging.CSMSHandler{

        default String[] name() { return new String[]{"A02"};}

    }
}
