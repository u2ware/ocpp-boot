package io.u2ware.ocpp.v1_6.messaging;

import java.util.HashMap;
import java.util.Map;

import io.u2ware.ocpp.core.OCPPFeature;

public class ChargePointFeature implements OCPPFeature{
    
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

    private ChargePointFeature(){ }

    private static ChargePointFeature createFeature(String usecase, String action, String identifier, Map<String,Object> attributes){
        ChargePointFeature u = new ChargePointFeature();
        u.setIdentifier(identifier+usecase);
        u.setUsecase(usecase);
        u.setAction(action);
        u.setAttributes(attributes);
        return u;
    }

    interface Builder {
        public String usecase(); 
        public String action();

        default ChargePointFeature build() {
            return build(Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default ChargePointFeature build(String identifier) {
            return build(identifier, new HashMap<>());
        }
    
        default ChargePointFeature build(String identifier, Map<String,Object> attributes) {
            return createFeature(usecase(), action(), identifier, attributes);
        }

        default ChargePointFeature buildWith(String feature) {
            return buildWith(feature, Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default ChargePointFeature buildWith(String feature, String identifier) {
            return buildWith(feature, identifier, new HashMap<>());
        }
    
        default ChargePointFeature buildWith(String feature, String identifier, Map<String,Object> attributes) {
            return createFeature(feature, action(), identifier, attributes);
        }
    }


    public enum Actions implements Builder {

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

        @Override
        public String usecase() {
            return "";
        }

        @Override
        public String action() {
            return name();            
        }
    }
}