package io.u2ware.ocpp.v2_1.messaging;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketSession;

import io.u2ware.ocpp.OCPPHandlerInvoker;
import io.u2ware.ocpp.OCPPSessionTemplate;

public class CSMSCommandTemplate extends OCPPSessionTemplate<CSMSCommand> implements CSMSCommandOperations {

    public CSMSCommandTemplate(CSMS operations, SimpMessageSendingOperations simpOperations) {
        super(operations, simpOperations);
    }


    public CSMSCommandTemplate(String description) {
        super(description, new CSMS().registerDefaultFeatures(), null);
    }    
    public CSMSCommandTemplate(String description, CSMS operations) {
        super(description, operations, null);
    }
    public CSMSCommandTemplate(String description, SimpMessageSendingOperations simpOperations) {
        super(description, new CSMS().registerDefaultFeatures(), simpOperations);
    }
    public CSMSCommandTemplate(String description, CSMS operations, SimpMessageSendingOperations simpOperations) {
        super(description, operations, simpOperations);
    }



    @Override
    public void send(String destination, CSMSCommand command) {

        String key = OCPPHandlerInvoker.extractElement(webSocketSessions.keySet(), destination);
        WebSocketSession session = webSocketSessions.get(key);
        if(session != null) {
            super.offer(session, command);
        }else{
            super.offer(destination, command);
        }
    }

    public void send(CSMSCommand command) {
        webSocketSessions.keySet().stream().findFirst().ifPresentOrElse((key) -> {
            WebSocketSession session = webSocketSessions.get(key);
            super.offer(session, command);
        }, ()->{
            error(this, new RuntimeException("CSMSCommandTemplate#send()",new NullPointerException("session")));
        });
    }

    @Override
    protected CSMSCommand convertCommand(String payload)  {
        try{
            CSMSCommand s = conversion.comfortableReadValue(payload, CSMSCommand.class);
            CSMSCommand c = CSMSCommand.ALL.valueOf(s.getAction()).build();
            if(StringUtils.hasText(s.getIdentifier())) c.setIdentifier(s.getIdentifier());
            if(StringUtils.hasText(s.getUsecase())) c.setUsecase(s.getUsecase());
            if(! ObjectUtils.isEmpty(s.getAttributes())) c.setAttributes(s.getAttributes());
            return c;
        }catch(Exception e){
            return null;
        }


    }
}