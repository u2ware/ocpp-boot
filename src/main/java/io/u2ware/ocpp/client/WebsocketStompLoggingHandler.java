package io.u2ware.ocpp.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.simp.stomp.ConnectionLostException;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.util.ClassUtils;

public class WebsocketStompLoggingHandler extends WebsocketStompGenericHandler<String> implements StompSessionHandler {

	protected Log logger = LogFactory.getLog(getClass());

    private String title;

    public WebsocketStompLoggingHandler(){
        this.title = "";
    }

    public WebsocketStompLoggingHandler(String title){
        this.title = title;
    }


    @Override
    public void handle(StompHeaders header, String payload) {
        logger.info(String.format("[%s] handle : %s", title, payload));
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info(String.format("[%s] afterConnected: ", title));
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.info(String.format("[%s] handleException: ", title), exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {

        if(ClassUtils.isAssignableValue(ConnectionLostException.class, exception)) {
            logger.info(String.format("[%s] handleTransportError ConnectionLostException:  ", title));
        }else{
            logger.info(String.format("[%s] handleTransportError: ", title, exception));
        }
    }    
}
