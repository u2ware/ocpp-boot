package io.u2ware.ocpp.v2_0_1.messaging;

// import org.springframework.messaging.simp.SimpMessageSendingOperations;
// import org.springframework.messaging.simp.SimpMessagingTemplate;

public interface SpecificationSendingOperations {
    
    public void convertAndSend(SpecificationAction payload);
    public void convertAndSend(String destination, SpecificationAction payload) ;



    // SimpMessageSendingOperations f;
    // SimpMessagingTemplate d;
}
