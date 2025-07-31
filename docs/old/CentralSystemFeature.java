package io.u2ware.ocpp.v1_6.messaging;

import java.util.HashMap;
import java.util.Map;

import io.u2ware.ocpp.core.OCPPFeature;

public class CentralSystemFeature implements OCPPFeature{

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


    private CentralSystemFeature(){ }

    private static CentralSystemFeature createFeature(String usecase, String action, String identifier, Map<String,Object> attributes){
        CentralSystemFeature u = new CentralSystemFeature();
        u.setIdentifier(identifier+usecase);
        u.setUsecase(usecase);
        u.setAction(action);
        u.setAttributes(attributes);
        return u;
    }

    public interface Builder {
        public String usecase(); 
        public String action();

        default CentralSystemFeature build() {
            return build(Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default CentralSystemFeature build(String identifier) {
            return build(identifier, new HashMap<>());
        }
    
        default CentralSystemFeature build(String identifier, Map<String,Object> attributes) {
            return createFeature(usecase(), action(), identifier, attributes);
        }

        default CentralSystemFeature buildWith(String feature) {
            return buildWith(feature, Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default CentralSystemFeature buildWith(String feature, String identifier) {
            return buildWith(feature, identifier, new HashMap<>());
        }
    
        default CentralSystemFeature buildWith(String feature, String identifier, Map<String,Object> attributes) {
            return createFeature(feature, action(), identifier, attributes);
        }
    }


    public enum Actions implements Builder {

        Authorize,
        BootNotification,
        DataTransfer,    
        DiagnosticsStatusNotification,
        FirmwareStatusNotification,
        Heartbeat,
        MeterValues,
        StartTransaction,
        StatusNotification,
        StopTransaction,;

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