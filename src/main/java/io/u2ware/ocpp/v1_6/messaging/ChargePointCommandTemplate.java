package io.u2ware.ocpp.v1_6.messaging;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;

import io.u2ware.ocpp.OCPPHandlerInvoker;
import io.u2ware.ocpp.OCPPSessionTemplate;

@RestController
public class ChargePointCommandTemplate extends OCPPSessionTemplate<ChargePointCommand> implements ChargePointCommandOperations {


    public ChargePointCommandTemplate(ChargePoint operations, SimpMessageSendingOperations simpOperations) {
        super(operations, simpOperations);
    }


    public ChargePointCommandTemplate(String description) {
        super(description, new ChargePoint().registerDefaultHandlers(), null);
    }    
    public ChargePointCommandTemplate(String description, ChargePoint operations) {
        super(description, operations, null);
    }
    public ChargePointCommandTemplate(String description, SimpMessageSendingOperations simpOperations) {
        super(description, new ChargePoint().registerDefaultHandlers(), simpOperations);
    }
    public ChargePointCommandTemplate(String description, ChargePoint operations, SimpMessageSendingOperations simpOperations) {
        super(description, operations, simpOperations);
    }



    @Override
    public void send(String destination, ChargePointCommand command) {

        String key = OCPPHandlerInvoker.extractElement(webSocketSessions.keySet(), destination);
        WebSocketSession session = webSocketSessions.get(key);
        if(session != null) {
            super.offer(session, command);
        }else{
            super.offer(destination, command);
        }
    }

    public void send(ChargePointCommand command) {
        webSocketSessions.keySet().stream().findFirst().ifPresentOrElse((key) -> {
            WebSocketSession session = webSocketSessions.get(key);
            super.offer(session, command);
            
        }, ()->{
            error(this, new RuntimeException("ChargePointCommandTemplate#send()",new NullPointerException("session")));
        });
    }

    @Override
    protected ChargePointCommand convertCommand(String payload)  {
        try{
            ChargePointCommand s = conversion.comfortableReadValue(payload, ChargePointCommand.class);
            ChargePointCommand c = ChargePointCommand.ALL.valueOf(s.getAction()).build();
            if(StringUtils.hasText(s.getIdentifier())) c.setIdentifier(s.getIdentifier());
            if(StringUtils.hasText(s.getUsecase())) c.setUsecase(s.getUsecase());
            if(! ObjectUtils.isEmpty(s.getAttributes())) c.setAttributes(s.getAttributes());
            return c;
        }catch(Exception e){
            return null;
        }
    }
}