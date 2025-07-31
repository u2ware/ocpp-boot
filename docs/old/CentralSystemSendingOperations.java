package io.u2ware.ocpp.v1_6.messaging;

public interface CentralSystemSendingOperations {
    
    public void convertAndSend(CentralSystemFeature feature);
    public void convertAndSend(String destination, CentralSystemFeature feature) ;

}
