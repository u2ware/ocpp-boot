package io.u2ware.ocpp.v1_6.messaging;

import java.util.HashMap;
import java.util.Map;

import io.u2ware.ocpp.OCPPCommand;

public class ChargePointCommand extends OCPPCommand{
    
    private ChargePointCommand(){ }

    public interface Builder {
        public String usecase(); 
        public String action();

        default ChargePointCommand build() {
            return build(Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default ChargePointCommand build(String identifier) {
            return build(identifier, new HashMap<>());
        }
    
        default ChargePointCommand build(String identifier, Map<String,Object> attributes) {
            return create(usecase(), action(), identifier, attributes);
        }

        default ChargePointCommand buildWith(String usecase) {
            return buildWith(usecase, Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default ChargePointCommand buildWith(String usecase, String identifier) {
            return buildWith(usecase, identifier, new HashMap<>());
        }
    
        default ChargePointCommand buildWith(String usecase, String identifier, Map<String,Object> attributes) {
            return create(usecase, action(), identifier, attributes);
        }

        private static ChargePointCommand create(String usecase, String action, String identifier, Map<String,Object> attributes){
            ChargePointCommand u = new ChargePointCommand();
            u.setIdentifier(identifier+usecase);
            u.setUsecase(usecase);
            u.setAction(action);
            u.setAttributes(attributes);
            return u;
        }
    }

    public enum ALL implements Builder {

        Authorize,
        BootNotification,
        DataTransfer,    
        DiagnosticsStatusNotification,
        FirmwareStatusNotification,

        Heartbeat,
        MeterValues,
        StartTransaction,
        StatusNotification,
        StopTransaction,
        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }


    public enum Core implements Builder{
        Authorize,
        BootNotification,
        DataTransfer,    
        
        Heartbeat,
        MeterValues,
        StartTransaction,
        StatusNotification,
        StopTransaction,

        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }

    public enum FirmwareManagement implements Builder{
        DiagnosticsStatusNotification,
        FirmwareStatusNotification,
        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }

    public enum LocalAuthListManagement implements Builder{
        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }
    public enum RemoteTrigger implements Builder{
        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }

    public enum Reservation implements Builder{
        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }

    public enum SmartCharging implements Builder{
        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }

}