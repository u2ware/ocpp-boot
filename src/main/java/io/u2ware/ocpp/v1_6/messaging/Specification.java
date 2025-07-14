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
            BootNotification("4.2. Boot Notification", null),
            DataTransfer("4.3. Data Transfer", InitiatedByChargePoint.DataTransfer.DataTransfer),    
            DiagnosticsStatusNotification("4.4. Diagnostics Status Notification", null),
            FirmwareStatusNotification("4.5. Firmware Status Notification", null),
            Heartbeat("4.6. Heartbeat", null),
            MeterValues("4.7. Meter Values", null),
            StartTransaction("4.8. Start Transaction", InitiatedByChargePoint.StartTransaction.StartTransaction),
            StatusNotification("4.9. Status Notification", null),
            StopTransaction("4.10. Stop Transaction", null),

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
        public enum DataTransfer implements Specification{
            DataTransfer,
            ;
            public String usecase() {return "DataTransfer";}
            public String action() {return name();}
        }
        public enum StartTransaction implements Specification{
            StartTransaction,
            ;
            public String usecase() {return "StartTransaction";}
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

            CancelReservation("5.1. Cancel Reservation", null),
            ChangeAvailability("5.2. Change Availability", null),
            ChangeConfiguration("5.3. Change Configuration", null),
            ClearCache("5.4. Clear Cache", null),
            ClearChargingProfile("5.5. Clear Charging Profile", null),
            DataTransfer("5.6. Data Transfer", InitiatedByCentralSystem.DataTransfer.DataTransfer),
            GetCompositeSchedule("5.7. Get Composite Schedule", null),
            GetConfiguration("5.8. Get Configuration", null),
            GetDiagnostics("5.9. Get Diagnostics", InitiatedByCentralSystem.GetDiagnostics.GetDiagnostics),
            GetLocalListVersion("5.10. Get Local List Version", null),
            RemoteStartTransaction("5.11. Remote Start Transaction", null),
            RemoteStopTransaction("5.12. Remote Stop Transaction", null),
            ReserveNow("5.13. Reserve Now", null),
            Reset("5.14. Reset", null),
            SendLocalList("5.15. Send Local List", null),
            SetChargingProfile("5.16. Set Charging Profile", InitiatedByCentralSystem.SetChargingProfile.SetChargingProfile),
            TriggerMessage("5.17. Trigger Message", InitiatedByCentralSystem.TriggerMessage.TriggerMessage),
            UnlockConnector("5.18. Unlock Connector", null),
            UpdateFirmware("5.19. Update Firmware", null),

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


        public enum DataTransfer implements Specification{
            DataTransfer,
            ;
            public String usecase() {return "DataTransfer";}
            public String action() {return name();}
        }

        public enum GetDiagnostics implements Specification{
            GetDiagnostics,
            DiagnosticsStatusNotification,
            ;
            public String usecase() {return "GetDiagnostics";}
            public String action() {return name();}
        }

        public enum TriggerMessage implements Specification{
            TriggerMessage,
            StatusNotification,
            ;
            public String usecase() {return "TriggerMessage";}
            public String action() {return name();}
        }

        public enum SetChargingProfile implements Specification{
            SetChargingProfile,
            ;
            public String usecase() {return "SetChargingProfile";}
            public String action() {return name();}
        }

    }


}
