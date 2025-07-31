package io.u2ware.ocpp.v1_6.messaging.old;

import java.util.HashMap;
import java.util.Map;

public interface Specification {

    public String usecase(); 
    public String action();

    default SpecificationFeature feature() {
        return feature(Long.toString(System.currentTimeMillis()), new HashMap<>());
    }

    default SpecificationFeature feature(String identifier) {
        return feature(identifier, new HashMap<>());
    }
   
    default SpecificationFeature feature(String identifier, Map<String,Object> attributes) {
        return createFeature(usecase(), action(), identifier, attributes);
    }

    default SpecificationFeature featureOf(String feature) {
        return featureOf(feature, Long.toString(System.currentTimeMillis()), new HashMap<>());
    }

    default SpecificationFeature featureOf(String feature, String identifier) {
        return featureOf(feature, identifier, new HashMap<>());
    }
   
    default SpecificationFeature featureOf(String feature, String identifier, Map<String,Object> attributes) {
        return createFeature(feature, action(), identifier, attributes);
    }


    private static SpecificationFeature createFeature(String usecase, String action, String identifier, Map<String,Object> attributes){
        SpecificationFeature u = new SpecificationFeature();
        u.setIdentifier(identifier+usecase);
        u.setUsecase(usecase);
        u.setAction(action);
        u.setAttributes(attributes);
        return u;
    }

    // //////////////////////////////////////////////////
    // //
    // //////////////////////////////////////////////////
    // private static Specification[] arraycopy(Specification[]... s){
    //     int total = 0;
    //     for(Specification[] ss : s) {
    //         total = total + ss.length;
    //     }
    //     Specification[] r = new Specification[total];
    //     int position = 0;
    //     for(Specification[] ss : s) {
    //         System.arraycopy(ss, 0, r, position, ss.length);
    //         position = ss.length;
    //     }
    //     return r;
    // }

    // public static Specification[] usecases(SpecificationOperations operation){

    //     return  arraycopy(
    //         InitiatedByChargePoint.usecases(operation), 
    //         InitiatedByCentralSystem.usecases(operation)
    //     );
    // }    

    
    // //////////////////////////////////////////////////
    // //
    // //////////////////////////////////////////////////
    // public enum InitiatedByChargePoint implements Specification {

    //     Authorize,
    //     BootNotification,
    //     DataTransfer,    
    //     DiagnosticsStatusNotification,
    //     FirmwareStatusNotification,
    //     Heartbeat,
    //     MeterValues,
    //     StartTransaction,
    //     StatusNotification,
    //     StopTransaction,
    //     ;

    //     public static Specification[] usecases(SpecificationOperations operation){
    //         if(ObjectUtils.isEmpty(operation)) {
    //             return values();
    //         }else if(operation.isServer()){
    //             return new Specification[]{};
    //         }else{
    //             return values();
    //         }
    //     }

    //     public String action() {return name();}       
    // }

    // //////////////////////////////////////////////////
    // //
    // //////////////////////////////////////////////////
    // public enum InitiatedByCentralSystem implements Specification {

    //     CancelReservation,
    //     ChangeAvailability,
    //     ChangeConfiguration,
    //     ClearCache,
    //     ClearChargingProfile,

    //     DataTransfer,
    //     GetCompositeSchedule,
    //     GetConfiguration,
    //     GetDiagnostics,
    //     GetLocalListVersion,

    //     RemoteStartTransaction,
    //     RemoteStopTransaction,
    //     ReserveNow,
    //     Reset,
    //     SendLocalList,

    //     SetChargingProfile,
    //     TriggerMessage,
    //     UnlockConnector,
    //     UpdateFirmware,

    //     ;

    //     public static Specification[] usecases(SpecificationOperations operation){
    //         if(ObjectUtils.isEmpty(operation)) {
    //             return values();
    //         }else if(operation.isServer()){
    //             return values();
    //         }else{
    //             return new Specification[]{};
    //         }
    //     }

    //     public String action() {return name();}
    // }

    // public enum Core implements Specification{

    //     Authorize,
    //     BootNotification,
    //     ChangeAvailability,
    //     ChangeConfiguration,
    //     ClearCache,

    //     DataTransfer,
    //     GetConfiguration,
    //     Heartbeat,
    //     MeterValues,
    //     RemoteStartTransaction,

    //     RemoteStopTransaction,
    //     Reset,
    //     StartTransaction,
    //     StopTransaction,
    //     UnlockConnector,
    //     ;
    //     public String action() {return name();}       
    // }

    // public enum FirmwareManagement implements Specification{
    //     GetDiagnostics,
    //     DiagnosticsStatusNotification,
    //     FirmwareStatusNotification,
    //     UpdateFirmware,
    //     ;
    //     public String action() {return name();}                   
    // }

    // public enum LocalAuthListManagement implements Specification{
    //     GetLocalListVersion,
    //     SendLocalList,
    //     ;
    //     public String action() {return name();}
    // }
    // public enum RemoteTrigger implements Specification{
    //     CancelReservation,
    //     ReserveNow,
    //     ;
    //     public String action() {return name();}
    // }

    // public enum Reservation implements Specification{
    //     ClearChargingProfile,
    //     GetCompositeSchedule,
    //     SetChargingProfile,
    //     ;
    //     public String action() {return name();}
    // }

    // public enum SmartCharging implements Specification{
    //     TriggerMessage,
    //     StatusNotification,
    //     ;
    //     public String action() {return name();}
    // }
}
