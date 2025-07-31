package io.u2ware.ocpp.v2_0_1.messaging;

import java.util.HashMap;
import java.util.Map;

import io.u2ware.ocpp.OCPPCommand;

public class CSMSCommand implements OCPPCommand{

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


    private CSMSCommand(){ }

    private static CSMSCommand createFeature(String usecase, String action, String identifier, Map<String,Object> attributes){
        CSMSCommand u = new CSMSCommand();
        u.setIdentifier(identifier+usecase);
        u.setUsecase(usecase);
        u.setAction(action);
        u.setAttributes(attributes);
        return u;
    }

    public interface Builder {
        public String usecase(); 
        public String action();

        default CSMSCommand build() {
            return build(Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default CSMSCommand build(String identifier) {
            return build(identifier, new HashMap<>());
        }
    
        default CSMSCommand build(String identifier, Map<String,Object> attributes) {
            return createFeature(usecase(), action(), identifier, attributes);
        }

        default CSMSCommand buildWith(String feature) {
            return buildWith(feature, Long.toString(System.currentTimeMillis()), new HashMap<>());
        }

        default CSMSCommand buildWith(String feature, String identifier) {
            return buildWith(feature, identifier, new HashMap<>());
        }
    
        default CSMSCommand buildWith(String feature, String identifier, Map<String,Object> attributes) {
            return createFeature(feature, action(), identifier, attributes);
        }
    }


    public enum InitiatedBy implements Builder {

//Authorize
//BootNotification
//CancelReservation
//CertificateSigned
//ChangeAvailability
//ClearCache
//ClearChargingProfile
//ClearDisplayMessage
//ClearVariableMonitoring
//ClearedChargingLimit
//CostUpdated
//CustomerInformation
//DataTransfer
//DeleteCertificate
//FirmwareStatusNotification
//Get15118EVCertificate
//GetBaseReport
//GetCertificateStatus
//GetChargingProfiles
//GetCompositeSchedule
//GetDisplayMessages
//GetInstalledCertificateIds
//GetLocalListVersion
//GetLog
//GetMonitoringReport
//GetReport
//GetTransactionStatus
//GetVariables
//Heartbeat
//InstallCertificate
//LogStatusNotification
//MeterValues
//NotifyChargingLimit
//NotifyCustomerInformation
//NotifyDisplayMessages
//NotifyEVChargingNeeds
//NotifyEVChargingSchedule
//NotifyEvent
//NotifyMonitoringReport
//NotifyReport
//PublishFirmware
//PublishFirmwareStatusNotification
//ReportChargingProfiles
//RequestStartTransaction
//RequestStopTransaction
//ReservationStatusUpdate
//ReserveNow
//Reset
//SecurityEventNotification
//SendLocalList
//SetChargingProfile
//SetDisplayMessage
//SetMonitoringBase
//SetMonitoringLevel
//SetNetworkProfile
//SetVariableMonitoring
//SetVariables
//SignCertificate
//StatusNotification
//TransactionEvent
//TriggerMessage
//UnlockConnector
//UnpublishFirmware
//UpdateFirmware
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

    public enum Security implements Builder {


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

    public enum A1 implements Builder {

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
