package io.u2ware.ocpp.v1_6.messaging;

import java.util.HashMap;
import java.util.Map;

import io.u2ware.ocpp.OCPPCommand;

public class CentralSystemCommand implements OCPPCommand{

    private CentralSystemCommand(){ }

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


    private static CentralSystemCommand createFeature(String usecase, String action, String identifier, Map<String,Object> attributes){
        CentralSystemCommand u = new CentralSystemCommand();
        u.setIdentifier(identifier+usecase);
        u.setUsecase(usecase);
        u.setAction(action);
        u.setAttributes(attributes);
        return u;
    }

    
    public interface Builder {
        public String usecase(); 
        public String action();

        default CentralSystemCommand build() {
            return build(Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default CentralSystemCommand build(String identifier) {
            return build(identifier, new HashMap<>());
        }
    
        default CentralSystemCommand build(String identifier, Map<String,Object> attributes) {
            return createFeature(usecase(), action(), identifier, attributes);
        }

        default CentralSystemCommand buildWith(String usecase) {
            return buildWith(usecase, Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default CentralSystemCommand buildWith(String usecase, String identifier) {
            return buildWith(usecase, identifier, new HashMap<>());
        }
    
        default CentralSystemCommand buildWith(String usecase, String identifier, Map<String,Object> attributes) {
            return createFeature(usecase, action(), identifier, attributes);
        }
    }


    public enum ALL implements Builder {
        CancelReservation,
        ChangeAvailability,
        ChangeConfiguration,
        ClearCache,
        ClearChargingProfile,
        DataTransfer,
        GetCompositeSchedule,
        GetConfiguration,
        GetDiagnostics,
        GetLocalListVersion,
        RemoteStartTransaction,
        RemoteStopTransaction,
        ReserveNow,
        Reset,
        SendLocalList,
        SetChargingProfile,
        TriggerMessage,
        UnlockConnector,
        UpdateFirmware,

        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }


    public enum Core implements Builder{
        ChangeAvailability,
        ChangeConfiguration,
        ClearCache,
        DataTransfer,
        GetConfiguration,
        RemoteStartTransaction,
        RemoteStopTransaction,
        Reset,
        UnlockConnector,
        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }

    public enum FirmwareManagement implements Builder{
        GetDiagnostics,
        UpdateFirmware,
        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }

    public enum LocalAuthListManagement implements Builder{
        GetLocalListVersion,
        SendLocalList,
        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }
    public enum RemoteTrigger implements Builder{
        CancelReservation,
        ReserveNow,
        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }

    public enum Reservation implements Builder{
        ClearChargingProfile,
        GetCompositeSchedule,
        SetChargingProfile,
        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }

    public enum SmartCharging implements Builder{
        TriggerMessage,
        ;
        public String usecase() {return "";}
        public String action() {return name();}
    }
}