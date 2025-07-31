package io.u2ware.ocpp.v2_0_1.messaging.old3;

import java.lang.reflect.Method;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat.Features;

import io.u2ware.ocpp.core.OCPPReflection;
import io.u2ware.ocpp.v2_0_1.messaging.CSMSFeature;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStationFeature;

public interface SpecificationComment {

    public static String comment(ChargingStationFeature handler, String method, String id){
        Method m = OCPPReflection.resolveMethod(handler.getClass(), method);
        if(m == null) return null;

        String c = commentByUsecase("ChargingStation", handler.feature(), method, id);         
        if(c != null) return c;

        c = commentByAction("ChargingStation", handler.feature(), method, id);
        if(c != null) return c;

        return null;
    }

    public static String comment(CSMSFeature handler, String method, String id){

        Method m = OCPPReflection.resolveMethod(handler.getClass(), method);
        if(m == null) return null;

        String c = commentByUsecase("CSMS", handler.feature(), method, id);         
        if(c != null) return c;

        c = commentByAction("CSMS", handler.feature(), method, id);
        if(c != null) return c;

        return null;
    }


    private static String commentByUsecase(String operation, String feature, String method, String id){        
        try{
            FeatureComment u = FeatureComment.valueOf(feature);
            for(Enum<?> e : u.e){
                if(e.name().equals(method)) {
                    return String.format(
                        "\n\n\t[%s - %s] STEP(%d/%d): \n\t\t %s(%s) \n\t\t\t%s\n", 
                        u.c, 
                        u.s, 
                        e.ordinal() + 1, 
                        u.e.length, 
                        e.name(),
                        id,
                        e.toString()
                    );
                }
            }
        }catch(Exception e) {
            
        }
        return null;
    }

    private static String commentByAction(String operation, String feature, String method, String id){
        int i = 0;
        if(method.startsWith("send") && method.endsWith("Request")) { i = 1;}
        else if(method.startsWith("received") && method.endsWith("Request")) { i = 2;}
        else if(method.startsWith("received") && method.endsWith("Response")) { i = 3;}
        else if(method.startsWith("send") && method.endsWith("Response")) { i = 4;}
        if(i > 0) {
            return String.format(
                "\n\n\t[%s - %s] STEP(%d/%d): \n\t\t %s(%s) \n", 
                operation, 
                feature, 
                i, 
                4, 
                method,
                id
            );
        }else{
            return null;
        }
    }



    enum FeatureComment {
        A01("A. Security", "A01 - Update Charging Station Password for HTTP Basic Authentication", SpecificationComment.A01.values()),
        A02("A. Security", "A02 - Update Charging Station Certificate by request of CSMS", SpecificationComment.A02.values()),
        A03("A. Security", "A03 - Update Charging Station Certificate initiated by the Charging Station", SpecificationComment.A03.values()),
        A04("A. Security", "A04 - Security Event Notification", SpecificationComment.A04.values()),
        A05("A. Security", "A05 - Upgrade Charging Station Security Profile", SpecificationComment.A05.values()),
        ;
        FeatureComment(String c, String s, Enum<?>... e){this.c = c; this.s = s; this.e = e;} 
        String c; 
        String s; 
        Enum<?>[] e; 
    }

    enum A01 {
        sendSetVariablesRequest,
        receivedSetVariablesRequest,
        receivedSetVariablesResponse("disconnect", "connect (using new password)"),
        sendSetVariablesResponse,
        ;

        A01(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }


    enum A02 {
        sendTriggerMessageRequest,
        receivedTriggerMessageRequest,
        receivedTriggerMessageResponse,
        sendTriggerMessageResponse("generate new public / private key pair", "call next sendSignCertificateRequest"),

        sendSignCertificateRequest,
        receivedSignCertificateRequest,
        receivedSignCertificateResponse,
        sendSignCertificateResponse("forward CSR", "sign certificate", "return Signed Certificate", "call next sendCertificateSignedRequest"),

        sendCertificateSignedRequest,
        receivedCertificateSignedRequest("Verify validity of signed certificate"),
        receivedCertificateSignedResponse,
        sendCertificateSignedResponse("Switch to new certificate")
        ;

        A02(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }

    enum A03 {
        
        sendSignCertificateRequest("generate new public / private key pair"),
        receivedSignCertificateRequest,
        receivedSignCertificateResponse,
        sendSignCertificateResponse("forward CSR", "sign certificate", "return Signed Certificate", "call next sendCertificateSignedRequest"),

        sendCertificateSignedRequest,
        receivedCertificateSignedRequest("Verify validity of signed certificate"),
        receivedCertificateSignedResponse,
        sendCertificateSignedResponse("Switch to new certificate")

        ;

        A03(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }

    enum A04 {
        sendSecurityEventNotificationRequest("A security related event occurred"),
        receivedSecurityEventNotificationRequest,
        receivedSecurityEventNotificationResponse,
        sendSecurityEventNotificationResponse
        ;

        A04(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }

    public static enum A05 {
        sendSetVariablesRequest,
        receivedSetVariablesRequest,
        receivedSetVariablesResponse,
        sendSetVariablesResponse("call next sendResetRequest"),

        sendResetRequest,
        receivedResetRequest,
        receivedResetResponse,
        sendResetResponse("Reboot" , "Connect using (new) NetworkConnectionProfile with higher security profile", "call next sendBootNotificationRequest"),

        sendBootNotificationRequest,
        receivedBootNotificationRequest,
        receivedBootNotificationResponse,
        sendBootNotificationResponse
        ;


        A05(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }
}
