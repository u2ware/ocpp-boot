package io.u2ware.ocpp.v1_6.messaging;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;

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
        u.setIdentifier(identifier);
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
        public String profile();

        default String comment(Enum<?>[] comments, Enum<?> comment, String id){
            return String.format(
                "\n\n\t[%s - %s - %s] STEP(%d/%d): \n\t\t %s(%s) \n\t\t\t%s\n", 
                category(), 
                section(), 
                profile(), 
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

    public static Specification[] usecases(SpecificationOperations operation){
        if(ObjectUtils.isEmpty(operation)) {
            return arraycopy(InitiatedByChargePoint.values(), InitiatedByCentralSystem.values());
        }else if(operation.isServer()){
            return InitiatedByCentralSystem.values();
        }else{
            return InitiatedByChargePoint.values();
        }
    }    

    
    //////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////
    public enum InitiatedByChargePoint implements Specification, Section {

        Authorize("4.1. Authorize", "Core"),
        BootNotification("4.2. Boot Notification", "Core"),
        DataTransfer("4.3. Data Transfer", "Core"),    
        DiagnosticsStatusNotification("4.4. Diagnostics Status Notification",  "FirmwareManagement"),
        FirmwareStatusNotification("4.5. Firmware Status Notification",  "FirmwareManagement"),
        Heartbeat("4.6. Heartbeat",  "Core"),
        MeterValues("4.7. Meter Values",  "Core"),
        StartTransaction("4.8. Start Transaction",  "Core"),
        StatusNotification("4.9. Status Notification",  "SmartCharging"),
        StopTransaction("4.10. Stop Transaction",  "Core"),
        ;

        public static Specification[] usecases(SpecificationOperations operation){
            if(ObjectUtils.isEmpty(operation)) {
                return values();
            }else if(operation.isServer()){
                return new Specification[]{};
            }else{
                return values();
            }
        }

        InitiatedByChargePoint(String t, String p){this.t = t; this.p = p;} 
        private String t; 
        private String p; 
        public String section(){return t;}
        public String profile(){return p;}
        public String category(){return "4. Operations Initiated by Charge Point";} 
        public String usecase(){return name();}
        public String action(){return name();}
    }

    //////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////
    public enum InitiatedByCentralSystem implements Specification, Section {


        CancelReservation("5.1. Cancel Reservation", "RemoteTrigger"),
        ChangeAvailability("5.2. Change Availability", "Core"),
        ChangeConfiguration("5.3. Change Configuration", "Core"),
        ClearCache("5.4. Clear Cache", "Core"),
        ClearChargingProfile("5.5. Clear Charging Profile", "Reservation"),
        DataTransfer("5.6. Data Transfer", "Core"),
        GetCompositeSchedule("5.7. Get Composite Schedule", "Reservation"),
        GetConfiguration("5.8. Get Configuration", "Core"),
        GetDiagnostics("5.9. Get Diagnostics", "FirmwareManagement"),
        GetLocalListVersion("5.10. Get Local List Version", "LocalAuthListManagement"),
        RemoteStartTransaction("5.11. Remote Start Transaction", "Core"),
        RemoteStopTransaction("5.12. Remote Stop Transaction", "Core"),
        ReserveNow("5.13. Reserve Now", "RemoteTrigger"),
        Reset("5.14. Reset", "Core"),
        SendLocalList("5.15. Send Local List", "LocalAuthListManagement"),
        SetChargingProfile("5.16. Set Charging Profile", "Reservation"),
        TriggerMessage("5.17. Trigger Message", "SmartCharging"),
        UnlockConnector("5.18. Unlock Connector", "Core"),
        UpdateFirmware("5.19. Update Firmware", "FirmwareManagement"),

        ;

        public static Specification[] usecases(SpecificationOperations operation){
            if(ObjectUtils.isEmpty(operation)) {
                return values();
            }else if(operation.isServer()){
                return values();
            }else{
                return new Specification[]{};
            }
        }

        InitiatedByCentralSystem(String t, String p){this.t = t; this.p = p;} 
        private String t; 
        private String p; 
        public String section(){return t;}
        public String profile(){return p;}
        public String category(){return "5. Operations Initiated by Central System";} 
        public String usecase(){return name();}
        public String action(){return name();}
    }

    public enum Core implements Specification, Section{

        Authorize("4.1. Authorize", "Core"),
        BootNotification("4.2. Boot Notification", "Core"),
        ChangeAvailability("5.2. Change Availability", "Core"),
        ChangeConfiguration("5.3. Change Configuration", "Core"),
        ClearCache("5.4. Clear Cache", "Core"),
        DataTransfer("4.3. Data Transfer", "Core"),
        GetConfiguration("5.8. Get Configuration", "Core"),
        Heartbeat("4.6. Heartbeat",  "Core"),
        MeterValues("4.7. Meter Values",  "Core"),
        RemoteStartTransaction("5.11. Remote Start Transaction", "Core"),
        RemoteStopTransaction("5.12. Remote Stop Transaction", "Core"),
        Reset("5.14. Reset", "Core"),
        StartTransaction("4.8. Start Transaction",  "Core"),
        StopTransaction("4.10. Stop Transaction",  "Core"),
        UnlockConnector("5.18. Unlock Connector", "Core"),
        ;

        public static Specification[] usecases(SpecificationOperations operation){
            if(ObjectUtils.isEmpty(operation)) {
                return values();
            }else if(operation.isServer()){
                return new Specification[]{ChangeAvailability, ChangeConfiguration, ClearCache, GetConfiguration, RemoteStartTransaction, RemoteStopTransaction, Reset, UnlockConnector};
            }else{
                return new Specification[]{Authorize, BootNotification, DataTransfer, Heartbeat, MeterValues, StartTransaction, StopTransaction};
            }
        }



        Core(String t, String p){this.t = t; this.p = p;} 
        private String t; 
        private String p; 
        public String category(){return "Core : Basic Charge Point functionality comparable with OCPP";} 
        public String section(){return t;}
        public String profile(){return p;}
        public String usecase() {return name();}
        public String action() {return name();}
    }

    public enum FirmwareManagement implements Specification, Section{
        GetDiagnostics("5.9. Get Diagnostics", "FirmwareManagement"),
        DiagnosticsStatusNotification("4.4. Diagnostics Status Notification",  "FirmwareManagement"),
        FirmwareStatusNotification("4.5. Firmware Status Notification",  "FirmwareManagement"),
        UpdateFirmware("5.19. Update Firmware", "FirmwareManagement"),
        ;

        public static Specification[] usecases(SpecificationOperations operation){
            if(ObjectUtils.isEmpty(operation)) {
                return values();
            }else if(operation.isServer()){
                return new Specification[]{GetDiagnostics, UpdateFirmware};
            }else{
                return new Specification[]{DiagnosticsStatusNotification, FirmwareStatusNotification};
            }
        }

        FirmwareManagement(String t, String p){this.t = t; this.p = p;} 
        private String t; 
        private String p; 
        public String category(){return "Firmware Management : Support for firmware update management and diagnostic log file download";} 
        public String section(){return t;}
        public String profile(){return p;}
        public String usecase() {return name();}
        public String action() {return name();}        
    }

    public enum LocalAuthListManagement implements Specification, Section{
        GetLocalListVersion("5.10. Get Local List Version", "LocalAuthListManagement"),
        SendLocalList("5.15. Send Local List", "LocalAuthListManagement"),
        ;

        public static Specification[] usecases(SpecificationOperations operation){
            if(ObjectUtils.isEmpty(operation)) {
                return values();
            }else if(operation.isServer()){
                return values();
            }else{
                return new Specification[]{};
            }
        }

        LocalAuthListManagement(String t, String p){this.t = t; this.p = p;} 
        private String t; 
        private String p; 
        public String category(){return "Local Auth List Management : Features to manage the local authorization list in Charge Points.";} 
        public String section(){return t;}
        public String profile(){return p;}
        public String usecase() {return name();}
        public String action() {return name();}           
    }
    public enum RemoteTrigger implements Specification, Section{
        CancelReservation("5.1. Cancel Reservation", "RemoteTrigger"),
        ReserveNow("5.13. Reserve Now", "RemoteTrigger"),
        ;

        public static Specification[] usecases(SpecificationOperations operation){
            if(ObjectUtils.isEmpty(operation)) {
                return values();
            }else if(operation.isServer()){
                return values();
            }else{
                return new Specification[]{};
            }
        }

        RemoteTrigger(String t, String p){this.t = t; this.p = p;} 
        private String t; 
        private String p; 
        public String category(){return "Remote Trigger : Support for remote triggering of Charge Point initiated messages";} 
        public String section(){return t;}
        public String profile(){return p;}
        public String usecase() {return name();}
        public String action() {return name();}
    }

    public enum Reservation implements Specification, Section{
        ClearChargingProfile("5.5. Clear Charging Profile", "Reservation"),
        GetCompositeSchedule("5.7. Get Composite Schedule", "Reservation"),
        SetChargingProfile("5.16. Set Charging Profile", "Reservation"),
        ;

        public static Specification[] usecases(SpecificationOperations operation){
            if(ObjectUtils.isEmpty(operation)) {
                return values();
            }else if(operation.isServer()){
                return values();
            }else{
                return new Specification[]{};
            }
        }      

        Reservation(String t, String p){this.t = t; this.p = p;} 
        private String t; 
        private String p; 
        public String category(){return "Reservation : Support for reservation of a Charge Point.";} 
        public String section(){return t;}
        public String profile(){return p;}
        public String usecase() {return name();}
        public String action() {return name();}
    }

    public enum SmartCharging implements Specification, Section{
        TriggerMessage("5.17. Trigger Message", "SmartCharging"),
        StatusNotification("4.9. Status Notification",  "SmartCharging"),
        ;
        public static Specification[] usecases(SpecificationOperations operation){
            if(ObjectUtils.isEmpty(operation)) {
                return values();
            }else if(operation.isServer()){
                return new Specification[]{TriggerMessage};
            }else{
                return new Specification[]{StatusNotification};
            }
        }       

        SmartCharging(String t, String p){this.t = t; this.p = p;} 
        private String t; 
        private String p; 
        public String category(){return "Smart Charging : Support for basic Smart Charging, for instance using control pilot.";} 
        public String section(){return t;}
        public String profile(){return p;}
        public String usecase() {return name();}
        public String action() {return name();}
    }
}
