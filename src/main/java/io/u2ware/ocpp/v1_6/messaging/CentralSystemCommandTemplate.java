package io.u2ware.ocpp.v1_6.messaging;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;

import io.u2ware.ocpp.OCPPHandlerInvoker;
import io.u2ware.ocpp.OCPPSessionTemplate;

@RestController
public class CentralSystemCommandTemplate extends OCPPSessionTemplate<CentralSystemCommand> implements CentralSystemCommandOperations {


    public CentralSystemCommandTemplate(CentralSystem operations, SimpMessageSendingOperations simpOperations) {
        super(operations, simpOperations);
    }


    public CentralSystemCommandTemplate(String description) {
        super(description, new CentralSystem().registerDefaultFeatures(), null);
    }    
    public CentralSystemCommandTemplate(String description, CentralSystem operations) {
        super(description, operations, null);
    }
    public CentralSystemCommandTemplate(String description, SimpMessageSendingOperations simpOperations) {
        super(description, new CentralSystem().registerDefaultFeatures(), simpOperations);
    }
    public CentralSystemCommandTemplate(String description, CentralSystem operations, SimpMessageSendingOperations simpOperations) {
        super(description, operations, simpOperations);
    }




    @Override
    public void send(String destination, CentralSystemCommand command) {

        String key = OCPPHandlerInvoker.extractElement(webSocketSessions.keySet(), destination);
        WebSocketSession session = webSocketSessions.get(key);
        if(session != null) {
            super.offer(session, command);
        }else{
            super.offer(destination, command);
        }
    }

    public void send(CentralSystemCommand command) {
        webSocketSessions.keySet().stream().findFirst().ifPresentOrElse((key) -> {
            WebSocketSession session = webSocketSessions.get(key);
            super.offer(session, command);
        }, ()->{
            error(this, new RuntimeException("CentralSystemCommandTemplate#send()",new NullPointerException("session")));
        });
    }

    @Override
    protected CentralSystemCommand convertCommand(String payload) {
        try{
            CentralSystemCommand s = conversion.comfortableReadValue(payload, CentralSystemCommand.class);
            CentralSystemCommand c = CentralSystemCommand.ALL.valueOf(s.getAction()).build();
            if(StringUtils.hasText(s.getIdentifier())) c.setIdentifier(s.getIdentifier());
            if(StringUtils.hasText(s.getUsecase())) c.setUsecase(s.getUsecase());
            if(! ObjectUtils.isEmpty(s.getAttributes())) c.setAttributes(s.getAttributes());
            return c;
        }catch(Exception e){
            return null;
        }
    }
}