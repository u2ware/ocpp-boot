package io.u2ware.ocpp.v1_6.messaging;


public interface ChargePointSendingOperations {
    
    public void convertAndSend(ChargePointFeature feature);
    public void convertAndSend(String destination, ChargePointFeature feature) ;

}
