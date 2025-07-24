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

        default String comment(Enum<?>[] comments, Enum<?> comment, String id){
            return String.format(
                "\n\n\t[%s - %s ] STEP(%d/%d): \n\t\t %s(%s) \n\t\t\t%s\n", 
                category(), 
                section(), 
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

        return  arraycopy(
            InitiatedByChargePoint.usecases(operation), 
            InitiatedByCentralSystem.usecases(operation)
        );
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

        InitiatedByChargePoint(String t, String u){this.t = t; this.u = u;} 
        private String t; 
        private String u; 
        public String category(){return "4. Operations Initiated by Charge Point";} 
        public String section(){return String.format("%s (%s)", t,u);}
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

        InitiatedByCentralSystem(String t, String u){this.t = t; this.u = u;} 
        private String t; 
        private String u; 
        public String category(){return "5. Operations Initiated by Central System";} 
        public String section(){return String.format("%s (%s)", t,u);}
        public String usecase(){return name();}
        public String action(){return name();}
    }

    public enum Core implements Specification{

        Authorize,
        BootNotification,
        ChangeAvailability,
        ChangeConfiguration,
        ClearCache,
        DataTransfer,
        GetConfiguration,
        Heartbeat,
        MeterValues,
        RemoteStartTransaction,
        RemoteStopTransaction,
        Reset,
        StartTransaction,
        StopTransaction,
        UnlockConnector,
        ;

        public String usecase() {return name();}
        public String action() {return name();}       
    }

    public enum FirmwareManagement implements Specification{
        GetDiagnostics,
        DiagnosticsStatusNotification,
        FirmwareStatusNotification,
        UpdateFirmware,
        ;

        public String usecase() {return name();}
        public String action() {return name();}                   
    }

    public enum LocalAuthListManagement implements Specification{
        GetLocalListVersion,
        SendLocalList,
        ;
        public String usecase() {return name();}
        public String action() {return name();}
    }
    public enum RemoteTrigger implements Specification{
        CancelReservation,
        ReserveNow,
        ;
        public String usecase() {return name();}
        public String action() {return name();}
    }

    public enum Reservation implements Specification{
        ClearChargingProfile,
        GetCompositeSchedule,
        SetChargingProfile,
        ;
        public String usecase() {return name();}
        public String action() {return name();}
    }

    public enum SmartCharging implements Specification{
        TriggerMessage,
        StatusNotification,
        ;
        public String usecase() {return name();}
        public String action() {return name();}
    }
}
