package io.u2ware.ocpp.v1_6.messaging;

import java.util.HashMap;
import java.util.Map;

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
        u.setIdentifier(identifier+usecase());
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
                "\n\n\t[%s - %s] STEP(%d/%d): \n\t\t %s(%s) \n\t\t\t%s\n", 
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

    public static Specification[] usecases(){
        return arraycopy(InitiatedByChargePoint.Usecase.values(), InitiatedByCentralSystem.Usecase.values());
    }
    public static Specification[] offers(SpecificationOperations actor){
        if(actor.isServer()) {
            return InitiatedByCentralSystem.Usecase.values();
        }else if(actor.isClient()) {
            return InitiatedByChargePoint.Usecase.values();
        }else{
            return arraycopy();
        }
    }





    
    //////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////
    public interface InitiatedByChargePoint {

        public enum Usecase implements Specification, Section {

            Authorize("4.1. Authorize", InitiatedByChargePoint.Authorize.Authorize),
            BootNotification("4.2. Boot Notification", InitiatedByChargePoint.BootNotification.BootNotification),
            DataTransfer("4.3. Data Transfer", InitiatedByChargePoint.DataTransfer.DataTransfer),    
            DiagnosticsStatusNotification("4.4. Diagnostics Status Notification", InitiatedByChargePoint.DiagnosticsStatusNotification.DiagnosticsStatusNotification),
            FirmwareStatusNotification("4.5. Firmware Status Notification", InitiatedByChargePoint.FirmwareStatusNotification.FirmwareStatusNotification),
            Heartbeat("4.6. Heartbeat", InitiatedByChargePoint.Heartbeat.Heartbeat),
            MeterValues("4.7. Meter Values", InitiatedByChargePoint.MeterValues.MeterValues),
            StartTransaction("4.8. Start Transaction", InitiatedByChargePoint.StartTransaction.StartTransaction),
            StatusNotification("4.9. Status Notification", InitiatedByChargePoint.StatusNotification.StatusNotification),
            StopTransaction("4.10. Stop Transaction", InitiatedByChargePoint.StopTransaction.StopTransaction),

            ;
            Usecase(String t, Specification s){this.t = t; this.s = s;} 
            private String t; 
            private Specification s; 
            public String section(){return t;}
            public String category(){return "4. Operations Initiated by Charge Point";} 
            public String usecase(){return name();}
            public String action(){return s != null ? s.action() : null;}
            public SpecificationAction message(String i, Map<String, Object> a) { return  s != null ? s.message(i, a): null;}
        }
        public enum Authorize implements Specification{
            Authorize,
            ;
            public String usecase() {return "Authorize";}
            public String action() {return name();}
        }
        public enum BootNotification implements Specification{
            BootNotification,
            ;
            public String usecase() {return "BootNotification";}
            public String action() {return name();}
        }
        public enum DataTransfer implements Specification{
            DataTransfer,
            ;
            public String usecase() {return "DataTransfer";}
            public String action() {return name();}
        }
        public enum DiagnosticsStatusNotification implements Specification{
            DiagnosticsStatusNotification,
            ;
            public String usecase() {return "DiagnosticsStatusNotification";}
            public String action() {return name();}
        }        
        public enum FirmwareStatusNotification implements Specification{
            FirmwareStatusNotification,
            ;
            public String usecase() {return "FirmwareStatusNotification";}
            public String action() {return name();}
        }  
        public enum Heartbeat implements Specification{
            Heartbeat,
            ;
            public String usecase() {return "Heartbeat";}
            public String action() {return name();}
        }
        public enum MeterValues implements Specification{
            MeterValues,
            ;
            public String usecase() {return "MeterValues";}
            public String action() {return name();}
        }
        public enum StartTransaction implements Specification{
            StartTransaction,
            ;
            public String usecase() {return "StartTransaction";}
            public String action() {return name();}
        }
        public enum StatusNotification implements Specification{
            StatusNotification,
            ;
            public String usecase() {return "StatusNotification";}
            public String action() {return name();}
        }
        public enum StopTransaction implements Specification{
            StopTransaction,
            ;
            public String usecase() {return "StopTransaction";}
            public String action() {return name();}
        }        
    }

    //////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////
    public interface InitiatedByCentralSystem {

        public static Specification[] usecases(){
            return InitiatedByCentralSystem.Usecase.values();
        }

        public enum Usecase implements Specification, Section {

            CancelReservation("5.1. Cancel Reservation", InitiatedByCentralSystem.CancelReservation.CancelReservation),
            ChangeAvailability("5.2. Change Availability", InitiatedByCentralSystem.ChangeAvailability.ChangeAvailability),
            ChangeConfiguration("5.3. Change Configuration", InitiatedByCentralSystem.ChangeConfiguration.ChangeConfiguration),
            ClearCache("5.4. Clear Cache", InitiatedByCentralSystem.ClearCache.ClearCache),
            ClearChargingProfile("5.5. Clear Charging Profile", InitiatedByCentralSystem.ClearChargingProfile.ClearChargingProfile),

            DataTransfer("5.6. Data Transfer", InitiatedByCentralSystem.DataTransfer.DataTransfer),

            GetCompositeSchedule("5.7. Get Composite Schedule", InitiatedByCentralSystem.GetCompositeSchedule.GetCompositeSchedule),
            GetConfiguration("5.8. Get Configuration", InitiatedByCentralSystem.GetConfiguration.GetConfiguration),
            GetDiagnostics("5.9. Get Diagnostics", InitiatedByCentralSystem.GetDiagnostics.GetDiagnostics),
            GetLocalListVersion("5.10. Get Local List Version", InitiatedByCentralSystem.GetLocalListVersion.GetLocalListVersion),

            RemoteStartTransaction("5.11. Remote Start Transaction", InitiatedByCentralSystem.RemoteStartTransaction.RemoteStartTransaction),
            RemoteStopTransaction("5.12. Remote Stop Transaction", InitiatedByCentralSystem.RemoteStopTransaction.RemoteStopTransaction),
            ReserveNow("5.13. Reserve Now", InitiatedByCentralSystem.ReserveNow.ReserveNow),
            Reset("5.14. Reset", InitiatedByCentralSystem.Reset.Reset),

            SendLocalList("5.15. Send Local List", InitiatedByCentralSystem.SendLocalList.SendLocalList),
            SetChargingProfile("5.16. Set Charging Profile", InitiatedByCentralSystem.SetChargingProfile.SetChargingProfile),
            TriggerMessage("5.17. Trigger Message", InitiatedByCentralSystem.TriggerMessage.TriggerMessage),
            UnlockConnector("5.18. Unlock Connector", InitiatedByCentralSystem.UnlockConnector.UnlockConnector),
            UpdateFirmware("5.19. Update Firmware", InitiatedByCentralSystem.UpdateFirmware.UpdateFirmware),

            ;
            Usecase(String t, Specification s){this.t = t; this.s = s;} 
            private String t; 
            private Specification s; 
            public String section(){return t;}
            public String category(){return "5. Operations Initiated by Central System";} 
            public String usecase(){return name();}
            public String action(){return s != null ? s.action() : null;}
            public SpecificationAction message(String i, Map<String, Object> a) { return  s != null ? s.message(i, a): null;}
        }
        public enum CancelReservation implements Specification{
            CancelReservation,
            ;
            public String usecase() {return "CancelReservation";}
            public String action() {return name();}
        }
        public enum ChangeAvailability implements Specification{
            ChangeAvailability,
            ;
            public String usecase() {return "ChangeAvailability";}
            public String action() {return name();}
        }
        public enum ChangeConfiguration implements Specification{
            ChangeConfiguration,
            ;
            public String usecase() {return "ChangeConfiguration";}
            public String action() {return name();}
        }
        public enum ClearCache implements Specification{
            ClearCache,
            ;
            public String usecase() {return "ClearCache";}
            public String action() {return name();}
        }
        public enum ClearChargingProfile implements Specification{
            ClearChargingProfile,
            ;
            public String usecase() {return "ClearChargingProfile";}
            public String action() {return name();}
        }
        public enum DataTransfer implements Specification{
            DataTransfer,
            ;
            public String usecase() {return "DataTransfer";}
            public String action() {return name();}
        }
        public enum GetCompositeSchedule implements Specification{
            GetCompositeSchedule,
            ;
            public String usecase() {return "GetCompositeSchedule";}
            public String action() {return name();}
        }
        public enum GetConfiguration implements Specification{
            GetConfiguration,
            ;
            public String usecase() {return "GetConfiguration";}
            public String action() {return name();}
        }
        public enum GetDiagnostics implements Specification{
            GetDiagnostics,
            ;
            public String usecase() {return "GetDiagnostics";}
            public String action() {return name();}
        }
        public enum GetLocalListVersion implements Specification{
            GetLocalListVersion,
            ;
            public String usecase() {return "GetLocalListVersion";}
            public String action() {return name();}
        }
        public enum RemoteStartTransaction implements Specification{
            RemoteStartTransaction,
            ;
            public String usecase() {return "RemoteStartTransaction";}
            public String action() {return name();}
        }
        public enum RemoteStopTransaction implements Specification{
            RemoteStopTransaction,
            ;
            public String usecase() {return "RemoteStopTransaction";}
            public String action() {return name();}
        }
        public enum ReserveNow implements Specification{
            ReserveNow,
            ;
            public String usecase() {return "ReserveNow";}
            public String action() {return name();}
        }
        public enum Reset implements Specification{
            Reset,
            ;
            public String usecase() {return "Reset";}
            public String action() {return name();}
        }
        public enum SendLocalList implements Specification{
            SendLocalList,
            ;
            public String usecase() {return "SendLocalList";}
            public String action() {return name();}
        }
        public enum SetChargingProfile implements Specification{
            SetChargingProfile,
            ;
            public String usecase() {return "SetChargingProfile";}
            public String action() {return name();}
        }
        public enum TriggerMessage implements Specification{
            TriggerMessage,
            ;
            public String usecase() {return "TriggerMessage";}
            public String action() {return name();}
        }
        public enum UnlockConnector implements Specification{
            UnlockConnector,
            ;
            public String usecase() {return "UnlockConnector";}
            public String action() {return name();}
        }
        public enum UpdateFirmware implements Specification{
            UpdateFirmware,
            ;
            public String usecase() {return "UpdateFirmware";}
            public String action() {return name();}
        }
    }


}
