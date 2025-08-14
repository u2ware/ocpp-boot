package io.u2ware.ocpp.v2_0_1.messaging;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketSession;

import io.u2ware.ocpp.OCPPHandlerInvoker;
import io.u2ware.ocpp.OCPPSessionTemplate;

public class ChargingStationCommandTemplate extends OCPPSessionTemplate<ChargingStationCommand> implements ChargingStationCommandOperations {

    public ChargingStationCommandTemplate(ChargingStation operations, SimpMessageSendingOperations simpOperations) {
        super(operations, simpOperations);
    }


    public ChargingStationCommandTemplate(String description) {
        super(description, new ChargingStation().registerDefaultHandlers(), null);
    }    
    public ChargingStationCommandTemplate(String description, ChargingStation operations) {
        super(description, operations, null);
    }
    public ChargingStationCommandTemplate(String description, SimpMessageSendingOperations simpOperations) {
        super(description, new ChargingStation().registerDefaultHandlers(), simpOperations);
    }
    public ChargingStationCommandTemplate(String description, ChargingStation operations, SimpMessageSendingOperations simpOperations) {
        super(description, operations, simpOperations);
    }



    @Override
    public void send(String destination, ChargingStationCommand command) {

        String key = OCPPHandlerInvoker.extractElement(webSocketSessions.keySet(), destination);
        WebSocketSession session = webSocketSessions.get(key);
        if(session != null) {
            super.offer(session, command);
        }else{
            super.offer(destination, command);
        }
    }

    public void send(ChargingStationCommand command) {
        webSocketSessions.keySet().stream().findFirst().ifPresentOrElse((key) -> {
            WebSocketSession session = webSocketSessions.get(key);
            super.offer(session, command);
        }, ()->{
            error(this, new RuntimeException("ChargingStationCommandTemplate#send()",new NullPointerException("session")));
        });
    }

    @Override
    protected ChargingStationCommand convertCommand(String payload) {
        try{
            ChargingStationCommand s = conversion.comfortableReadValue(payload, ChargingStationCommand.class);
            ChargingStationCommand c = ChargingStationCommand.ALL.valueOf(s.getAction()).build();
            if(StringUtils.hasText(s.getIdentifier())) c.setIdentifier(s.getIdentifier());
            if(StringUtils.hasText(s.getUsecase())) c.setUsecase(s.getUsecase());
            if(! ObjectUtils.isEmpty(s.getAttributes())) c.setAttributes(s.getAttributes());
            return c;

        }catch(Exception e){
            return null;
        }
    }
}