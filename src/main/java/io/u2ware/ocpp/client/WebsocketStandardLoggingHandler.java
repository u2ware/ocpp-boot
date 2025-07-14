package io.u2ware.ocpp.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebsocketStandardLoggingHandler extends TextWebSocketHandler{


	protected Log logger = LogFactory.getLog(getClass());

    private String title;

    public WebsocketStandardLoggingHandler(String title){
        this.title = title;
    }    

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info(String.format("[%s] afterConnectionEstablished: ", title, session));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        logger.info(String.format("[%s] afterConnectionClosed: ", title, session));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info(String.format("[%s] handleTextMessage: %s", title, message.getPayload()));
	}    

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        logger.info(String.format("[%s] handleTransportError: ", title, exception));
    }


    
}
