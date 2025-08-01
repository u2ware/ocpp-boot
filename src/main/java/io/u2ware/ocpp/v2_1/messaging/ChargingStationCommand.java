package io.u2ware.ocpp.v2_1.messaging;

import java.util.HashMap;
import java.util.Map;

import io.u2ware.ocpp.OCPPCommand;


public class ChargingStationCommand extends OCPPCommand{

    private ChargingStationCommand(){ }

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
            return create(usecase(), action(), identifier, attributes);
        }

        default ChargingStationCommand buildWith(String feature) {
            return buildWith(feature, Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default ChargingStationCommand buildWith(String feature, String identifier) {
            return buildWith(feature, identifier, new HashMap<>());
        }
    
        default ChargingStationCommand buildWith(String feature, String identifier, Map<String,Object> attributes) {
            return create(feature, action(), identifier, attributes);
        }

        private static ChargingStationCommand create(String usecase, String action, String identifier, Map<String,Object> attributes){
            ChargingStationCommand u = new ChargingStationCommand();
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
        public String usecase() {return "";}
        public String action() {return name();}
    }
}