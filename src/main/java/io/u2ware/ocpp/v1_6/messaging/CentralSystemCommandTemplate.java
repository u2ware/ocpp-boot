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

    public CentralSystemCommandTemplate() {
        super(new CentralSystem().registerDefaultFeatures(), null);
    }

    public CentralSystemCommandTemplate(SimpMessageSendingOperations operations) {
        super(new CentralSystem().registerDefaultFeatures(), operations);
    }

    public CentralSystemCommandTemplate(CentralSystem operations, SimpMessageSendingOperations simpOperations) {
        super(operations, simpOperations);
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
            error(this, "ERROR", new NullPointerException("session"));
        });
    }

    @Override
    protected CentralSystemCommand convert(String payload) throws Exception {
        CentralSystemCommand s = conversion.comfortableReadValue(payload, CentralSystemCommand.class);
        CentralSystemCommand c = CentralSystemCommand.ALL.valueOf(s.getAction()).build();
        if(StringUtils.hasText(s.getIdentifier())) c.setIdentifier(s.getIdentifier());
        if(StringUtils.hasText(s.getUsecase())) c.setUsecase(s.getUsecase());
        if(! ObjectUtils.isEmpty(s.getAttributes())) c.setAttributes(s.getAttributes());
        return c;
    }











    // //////////////////////////////////////////////
    // //
    // //////////////////////////////////////////////
    // @MessageMapping("console")
    // public void received(@Payload String payload) {
    //     connections.keySet().stream().findFirst().ifPresentOrElse((id) -> {
    //         this.received(id, payload);
    //     }, ()->{
    //         error(null, "ERROR", new NullPointerException("session"));
    //     });
    // }

    // @MessageMapping("console.{dest}")
    // public void received(@DestinationVariable(value = "dest") String destination, @Payload String text) {

    //     logger.info("received: "+destination);
    //     logger.info("received: "+text);

    //     JsonNode payload = null;
    //     try {
    //         payload = mapper.readTree(text);
    //     }catch(Exception e) {
    //         error(null, "ERROR", new NullPointerException(text));
    //         return;
    //     }

    //     if(payload.isObject()) {

    //         WebSocketSession session = connections.get(destination);
    //         CentralSystemCommand command = convert(text);
    //         if(command == null) {
    //             error(null, "ERROR", new NullPointerException(text));
    //             return;
    //         }

    //         if(connections.containsKey(destination)) {
    //             logger.info("1: "+session);
    //             logger.info("1: "+command);
    //             super.offer(session, command);
    //         }else{
    //             logger.info("2: "+destination);
    //             logger.info("2: "+command);
    //             super.offer(destination, command);
    //         }

    //     }else if(payload.isArray()) {

    //         OCPPMessage<?> message = conversion.convertMessage(text);
    //         if(message == null) {
    //             error(null, "ERROR", new NullPointerException(text));
    //             return;
    //         }            
    //         logger.info("3: "+destination);
    //         logger.info("3: "+message);
    //         super.answer(destination, message);
    //     }
    // }

    // private CentralSystemCommand convert(String node){
    //     try{
    //         CentralSystemCommand s = mapper.readValue(node, CentralSystemCommand.class);
    //         CentralSystemCommand d = CentralSystemCommand.ALL.valueOf(s.getAction()).build();
    //         if(StringUtils.hasText(s.getUsecase())) d.setUsecase(s.getUsecase());
    //         if(StringUtils.hasText(s.getIdentifier())) d.setIdentifier(s.getIdentifier());
    //         if(! ObjectUtils.isEmpty(s.getAttributes())) d.setAttributes(s.getAttributes());
    //         return d;
    //     }catch(Exception e){
    //         return null;
    //     }
    // }
}