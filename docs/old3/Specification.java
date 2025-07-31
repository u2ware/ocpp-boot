package io.u2ware.ocpp.v2_0_1.messaging.old3;


import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;


public interface Specification {
    
    default String usecase() {return "";}
    public String action();

    default SpecificationFeature feature() {
        return feature(Long.toString(System.currentTimeMillis()), new HashMap<>());
    }

    default SpecificationFeature feature(String identifier) {
        return feature(identifier, new HashMap<>());
    }
   
    default SpecificationFeature feature(String identifier, Map<String,Object> attributes) {
        return createFeature(usecase(), action(), identifier, attributes);
    }

    default SpecificationFeature featureOf(String feature) {
        return featureOf(feature, Long.toString(System.currentTimeMillis()), new HashMap<>());
    }

    default SpecificationFeature featureOf(String feature, String identifier) {
        return featureOf(feature, identifier, new HashMap<>());
    }
   
    default SpecificationFeature featureOf(String feature, String identifier, Map<String,Object> attributes) {
        return createFeature(feature, action(), identifier, attributes);
    }

    private static SpecificationFeature createFeature(String usecase, String action, String identifier, Map<String,Object> attributes){
        SpecificationFeature u = new SpecificationFeature();
        u.setIdentifier(identifier+usecase);
        u.setUsecase(usecase);
        u.setAction(action);
        u.setAttributes(attributes);
        return u;
    }

    //////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////
    private static Specification[] arraycopy(Specification[]... s){
        int total = 0;
        for(Specification[] ss : s) {
            total = total + ss.length;
        }
        Specification[] r = new Specification[total];
        int position = 0;
        for(Specification[] ss : s) {
            System.arraycopy(ss, 0, r, position, ss.length);
            position = ss.length;
        }
        return r;
    }

    public static Specification[] usecases(SpecificationOperations operation){
        return arraycopy(
            Security.usecases(operation)
        );
    }  



    //////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////
    public enum Security implements Specification{
        A01("SetVariables"),
        A02("TriggerMessage"),
        A03("SignCertificate"),
        A04("SecurityEventNotification"),
        A05("SetVariables"),
        ;
        public static Specification[] usecases(SpecificationOperations operation){
            if(ObjectUtils.isEmpty(operation)) {
                return values();                    
            }else if(operation.isServer()) {
                return new Specification[]{A01, A02, A05};
            }else{
                return new Specification[]{A03, A04 };
            }
        }

        Security(String a){this.a = a;} 
        private String a; 
        public String usecase(){return name();}
        public String action(){return a;}
    }

    public enum A01 implements Specification{ 
        SetVariables
        ;
        public String action() {return name();}
    }

    public enum A02 implements Specification{ 
        TriggerMessage,
        SignCertificate,
        CertificateSigned,
        ;
        public String action() {return name();}
    }

    public enum A03 implements Specification{ 
        SignCertificate,
        CertificateSigned,
        ;
        public String action() {return name();}
    }
    
    public enum A04 implements Specification{ 
        SecurityEventNotification,            
        ;
        public String action() {return name();}
    }

    public enum A05 implements Specification{ 
        SetVariables,
        Reset,
        BootNotification,             
        ;
        public String action() {return name();}
    }


    //////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////




    //     B_Provisioning("B. Provisioning"),
    //     C_Authorization("C. Authorization"),
    //     D_LocalAuthorizationListManagement("D. LocalAuthorizationList Management"),
    //     E_Transactions("E. Transactions"),
    //     F_RemoteControl("F. RemoteControl"),
    //     G_Availability("G. Availability"),
    //     H_Reservation("H. Reservation"),
    //     I_TariffAndCost("I. TariffAndCost"),
    //     J_MeterValues("J. MeterValues"),
    //     K_SmartCharging("K. SmartCharging"),
    //     L_FirmwareManagement("L. FirmwareManagement"),
    //     M_ISO15118CertificateManagement("M. ISO 15118 CertificateManagement"),
    //     N_Diagnostics("N. Diagnostics"),
    //     O_DisplayMessage("O. DisplayMessage"),
    //     P_DataTransfer("P. DataTransfer"),    


}
