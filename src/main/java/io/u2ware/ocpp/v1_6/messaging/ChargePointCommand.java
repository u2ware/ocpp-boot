package io.u2ware.ocpp.v1_6.messaging;

import java.util.HashMap;
import java.util.Map;

import io.u2ware.ocpp.core.OCPPCommand;

public class ChargePointCommand implements OCPPCommand{
    
    private ChargePointCommand(){ }

    private Map<String,Object> attributes;
    private String usecase;
    private String action;
    private String identifier;

   
    public Map<String, Object> getAttributes() {
        return attributes;
    }
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
    public String getUsecase() {
        return usecase;
    }
    public void setUsecase(String usecase) {
        this.usecase = usecase;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }


    private static ChargePointCommand createFeature(String usecase, String action, String identifier, Map<String,Object> attributes){
        ChargePointCommand u = new ChargePointCommand();
        u.setIdentifier(identifier+usecase);
        u.setUsecase(usecase);
        u.setAction(action);
        u.setAttributes(attributes);
        return u;
    }

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
            return createFeature(usecase(), action(), identifier, attributes);
        }

        default ChargePointCommand buildWith(String usecase) {
            return buildWith(usecase, Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default ChargePointCommand buildWith(String usecase, String identifier) {
            return buildWith(usecase, identifier, new HashMap<>());
        }
    
        default ChargePointCommand buildWith(String usecase, String identifier, Map<String,Object> attributes) {
            return createFeature(usecase, action(), identifier, attributes);
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