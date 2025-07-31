package io.u2ware.ocpp.v1_6.messaging.old;

import java.lang.reflect.Method;

import io.u2ware.ocpp.core.OCPPReflection;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemHandler;
import io.u2ware.ocpp.v1_6.messaging.ChargePointFeature;

public interface SpecificationComment {
    
    public static String comment(ChargePointFeature handler, String method, String id){
        Method m = OCPPReflection.resolveMethod(handler.getClass(), method);
        if(m == null) return null;

        String c = commentByAction("ChargePoint", handler.feature(), method, id);
        if(c != null) return c;

        return null;
    }

    public static String comment(CentralSystemHandler handler, String method, String id){

        Method m = OCPPReflection.resolveMethod(handler.getClass(), method);
        if(m == null) return null;

        String c = commentByAction("CentralSystem", handler.feature(), method, id);
        if(c != null) return c;

        return null;
    }

    private static String commentByAction(String operation, String feature, String method, String id){

        return null;
    }




    

    enum ChargePointFeatureComment {

        Authorize("4. Operations Initiated by Charge Point", "4.1. Authorize", "Core"),
        BootNotification("4. Operations Initiated by Charge Point","4.2. Boot Notification", "Core"),
        DataTransfer("4. Operations Initiated by Charge Point","4.3. Data Transfer", "Core"),    
        DiagnosticsStatusNotification("4. Operations Initiated by Charge Point","4.4. Diagnostics Status Notification",  "FirmwareManagement"),
        FirmwareStatusNotification("4. Operations Initiated by Charge Point","4.5. Firmware Status Notification",  "FirmwareManagement"),
        Heartbeat("4. Operations Initiated by Charge Point","4.6. Heartbeat",  "Core"),
        MeterValues("4. Operations Initiated by Charge Point","4.7. Meter Values",  "Core"),
        StartTransaction("4. Operations Initiated by Charge Point","4.8. Start Transaction",  "Core"),
        StatusNotification("4. Operations Initiated by Charge Point","4.9. Status Notification",  "SmartCharging"),
        StopTransaction("4. Operations Initiated by Charge Point","4.10. Stop Transaction",  "Core"),
        ;

        ChargePointFeatureComment(String c, String s, String p){this.c = c; this.s = s;} 
        String c; 
        String s; 
    }

    enum CentralSystemFeatureComment {

        CancelReservation("5. Operations Initiated by Central System", "5.1. Cancel Reservation", "RemoteTrigger"),
        ChangeAvailability("5. Operations Initiated by Central System","5.2. Change Availability", "Core"),
        ChangeConfiguration("5. Operations Initiated by Central System","5.3. Change Configuration", "Core"),
        ClearCache("5. Operations Initiated by Central System","5.4. Clear Cache", "Core"),
        ClearChargingProfile("5. Operations Initiated by Central System","5.5. Clear Charging Profile", "Reservation"),
        DataTransfer("5. Operations Initiated by Central System","5.6. Data Transfer", "Core"),
        GetCompositeSchedule("5. Operations Initiated by Central System","5.7. Get Composite Schedule", "Reservation"),
        GetConfiguration("5. Operations Initiated by Central System","5.8. Get Configuration", "Core"),
        GetDiagnostics("5. Operations Initiated by Central System","5.9. Get Diagnostics", "FirmwareManagement"),
        GetLocalListVersion("5. Operations Initiated by Central System","5.10. Get Local List Version", "LocalAuthListManagement"),
        RemoteStartTransaction("5. Operations Initiated by Central System","5.11. Remote Start Transaction", "Core"),
        RemoteStopTransaction("5. Operations Initiated by Central System","5.12. Remote Stop Transaction", "Core"),
        ReserveNow("5. Operations Initiated by Central System","5.13. Reserve Now", "RemoteTrigger"),
        Reset("5. Operations Initiated by Central System","5.14. Reset", "Core"),
        SendLocalList("5. Operations Initiated by Central System","5.15. Send Local List", "LocalAuthListManagement"),
        SetChargingProfile("5. Operations Initiated by Central System","5.16. Set Charging Profile", "Reservation"),
        TriggerMessage("5. Operations Initiated by Central System","5.17. Trigger Message", "SmartCharging"),
        UnlockConnector("5. Operations Initiated by Central System","5.18. Unlock Connector", "Core"),
        UpdateFirmware("5. Operations Initiated by Central System","5.19. Update Firmware", "FirmwareManagement"),
        ;

        CentralSystemFeatureComment(String c, String s, String p){this.c = c; this.s = s;} 
        String c; 
        String s; 
    }


}
