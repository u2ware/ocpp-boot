package io.u2ware.ocpp.v2_0_1.messaging;

import java.util.HashMap;
import java.util.Map;

public interface Specification {
    
    public String usecase();
    public String action();

    default SpecificationAction message() {
        return message(Long.toString(System.currentTimeMillis()), new HashMap<>());
    }

    default SpecificationAction message(String identifier) {
        return message(identifier, new HashMap<>());
    }
   
    default SpecificationAction message(String identifier, Map<String,Object> attributes) {
        SpecificationAction u = new SpecificationAction();
        u.setIdentifier(identifier+usecase());
        u.setUsecase(usecase());
        u.setAction(action());
        u.setAttributes(attributes);
        return u;
    }

    //////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////

    public interface Section {

        public String category();
        public String section();

        default String comment(Enum<?>[] comments, Enum<?> comment, String id){
            return String.format(
                "\n\n\t[%s - %s] STEP(%d/%d): \n\t\t %s(%s) \n\t\t\t%s\n", 
                category(), 
                section(), 
                comment.ordinal() + 1, 
                comments.length, 
                comment.name(),
                id,
                comment.toString()
            );
        }
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

    public static Specification[] usecases(){
        return arraycopy(Security.Usecase.values());
    }
    public static Specification[] offers(SpecificationOperations actor){
        if(actor.isServer()) {
            return arraycopy(new Specification[]{Security.Usecase.A01, Security.Usecase.A02 , Security.Usecase.A05});
        }else if(actor.isClient()) {
            return arraycopy(new Specification[]{Security.Usecase.A03, Security.Usecase.A04 });
        }else{
            return arraycopy();
        }
    }



    //////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////
    public interface Security extends Specification{

        public enum Usecase implements Specification, Section{ 

            A01("A01 - Update Charging Station Password for HTTP Basic Authentication", Security.A01.SetVariables),
            A02("A02 - Update Charging Station Certificate by request of CSMS", Security.A02.TriggerMessage),
            A03("A03 - Update Charging Station Certificate initiated by the Charging Station", Security.A03.SignCertificate),
            A04("A04 - Security Event Notification", Security.A04.SecurityEventNotification),
            A05("A05 - Upgrade Charging Station Security Profile", Security.A05.SetVariables),
            ;

            Usecase(String t, Specification s){this.t = t; this.s = s;} 
            private String t; 
            private Specification s; 
            public String section(){return t;}
            public String category(){return "A. Security";} 
            public String usecase(){return name();}
            public String action(){return s != null ? s.action() : null;}
            public SpecificationAction message(String i, Map<String, Object> a) { return  s != null ? s.message(i, a): null;}
        }

        public enum A01 implements Specification{ 
            SetVariables
            ;
            public String usecase() {return "A01";}
            public String action() {return name();}
        }

        public enum A02 implements Security{ 
            TriggerMessage,
            SignCertificate,
            CertificateSigned,
            ;
            public String usecase() {return "A02";}
            public String action() {return name();}
        }

        public enum A03 implements Security{ 
            SignCertificate,
            CertificateSigned,
            ;
            public String usecase() {return "A03";}
            public String action() {return name();}
        }
        
        public enum A04 implements Security{ 
            SecurityEventNotification,            
            ;
            public String usecase() {return "A04";}
            public String action() {return name();}
        }

        public enum A05 implements Specification{ 
            SetVariables,
            Reset,
            BootNotification,             
            ;
            public String usecase() {return "A05";}
            public String action() {return name();}
        }
    }


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
