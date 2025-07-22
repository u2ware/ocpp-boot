package io.u2ware.ocpp.v1_6.messaging;

import java.util.Collection;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketSession;

import io.u2ware.ocpp.core.OCPPWebsocketTemplate;

public class SpecificationSendingTemplate extends OCPPWebsocketTemplate<SpecificationOperations> implements SpecificationSendingOperations {

    public SpecificationSendingTemplate(SpecificationOperations operations) {
        super(operations, null);
    }


    public SpecificationSendingTemplate(SpecificationOperations operations, SimpMessageSendingOperations simpOperations) {
        super(operations, simpOperations);
    }

    @Override
    public void convertAndSend(SpecificationAction payload) {
        connections.keySet().stream().findFirst().ifPresentOrElse((id) -> {
            convertAndSend(id, payload);
        }, ()->{
            brodcast(null, "ERROR90", new NullPointerException("session"));
        });
    }

    @Override
    public void convertAndSend(String destination, SpecificationAction payload) {

        String key = extractElement(connections.keySet(), destination);
        WebSocketSession session = connections.get(key);
        if(session == null) {
            brodcast(null, "ERROR91", new NullPointerException(destination));
            return;
        }

        if(! payload.getIdentifier().contains(session.getId())) {
            payload.setIdentifier(payload.getIdentifier()+""+session.getId());
        }
        operations.offer(payload, (m,e)->{ send(session, m, e);});
    }


    private String extractElement(Collection<String> elements, String source) {
        if(StringUtils.hasText(source)) { 
            for(String element : elements){
                // System.err.println(element+" "+source);
                if(source.contains(element)) {
                    return element;
                }
            }
        }
        return null;    
    } 
}