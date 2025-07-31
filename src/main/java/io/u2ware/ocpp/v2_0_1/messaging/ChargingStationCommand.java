package io.u2ware.ocpp.v2_0_1.messaging;

import java.util.HashMap;
import java.util.Map;

import io.u2ware.ocpp.OCPPCommand;


public class ChargingStationCommand implements OCPPCommand{

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


    private ChargingStationCommand(){ }

    private static ChargingStationCommand createFeature(String usecase, String action, String identifier, Map<String,Object> attributes){
        ChargingStationCommand u = new ChargingStationCommand();
        u.setIdentifier(identifier+usecase);
        u.setUsecase(usecase);
        u.setAction(action);
        u.setAttributes(attributes);
        return u;
    }

    public interface Builder {
        public String usecase(); 
        public String action();

        default ChargingStationCommand build() {
            return build(Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default ChargingStationCommand build(String identifier) {
            return build(identifier, new HashMap<>());
        }
    
        default ChargingStationCommand build(String identifier, Map<String,Object> attributes) {
            return createFeature(usecase(), action(), identifier, attributes);
        }

        default ChargingStationCommand buildWith(String feature) {
            return buildWith(feature, Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default ChargingStationCommand buildWith(String feature, String identifier) {
            return buildWith(feature, identifier, new HashMap<>());
        }
    
        default ChargingStationCommand buildWith(String feature, String identifier, Map<String,Object> attributes) {
            return createFeature(feature, action(), identifier, attributes);
        }
    }


    public enum ALL implements Builder {
        Authorize,
        BootNotification,
        ClearedChargingLimit,
        DataTransfer,
        FirmwareStatusNotification,
        Get15118EVCertificate,
        GetCertificateStatus,
        Heartbeat,
        LogStatusNotification,
        MeterValues,
        NotifyChargingLimit,
        NotifyCustomerInformation,
        NotifyDisplayMessages,
        NotifyEVChargingNeeds,
        NotifyEVChargingSchedule,
        NotifyEvent,
        NotifyMonitoringReport,
        NotifyReport,
        PublishFirmwareStatusNotification,
        ReportChargingProfiles,
        ReservationStatusUpdate,
        SecurityEventNotification,
        SignCertificate,
        StatusNotification,
        TransactionEvent,
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