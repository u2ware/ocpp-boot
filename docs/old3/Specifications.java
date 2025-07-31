package io.u2ware.ocpp.v2_0_1.messaging.old3;

import org.springframework.util.ObjectUtils;

public enum Specifications {
    

    SetVariables,
    TriggerMessage,
    SignCertificate,
    CertificateSigned,

    // SignCertificate,
    // CertificateSigned,
    SecurityEventNotification,   

    // SetVariables,
    Reset,
    BootNotification,   

    ;



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
        public String usecase(){return "A01";}
        public String action() {return name();}
    }

    public enum A02 implements Specification{ 
        TriggerMessage,
        SignCertificate,
        CertificateSigned,
        ;
        public String usecase(){return "A02";}
        public String action() {return name();}
    }

    public enum A03 implements Specification{ 
        SignCertificate,
        CertificateSigned,
        ;
        public String usecase(){return "A03";}
        public String action() {return name();}
    }
    
    public enum A04 implements Specification{ 
        SecurityEventNotification,            
        ;
        public String usecase(){return "A04";}
        public String action() {return name();}
    }

    public enum A05 implements Specification{ 
        SetVariables,
        Reset,
        BootNotification,             
        ;
        public String usecase(){return "A05";}
        public String action() {return name();}
    }


}
