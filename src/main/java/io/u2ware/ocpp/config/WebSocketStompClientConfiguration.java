package io.u2ware.ocpp.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

// import io.u2ware.ocpp.context.messaging.AbstractOcppSendingTemplate;

@Deprecated
@Configuration
@EnableScheduling
public class WebSocketStompClientConfiguration {

	protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired OcppAttributes ocppAttributes;
    // protected @Autowired AbstractOcppSendingTemplate<?> websocketHandler;


    @Bean
    public WebSocketStompClient webSocketStompClient() {
        WebSocketStompClient manager = new WebSocketStompClient(webSocketClient());
        manager.setMessageConverter(new StringMessageConverter());
        manager.setAutoStartup(true);

        // SubProtocolEventPublisher();

        return manager;
    }


    @Bean
    public WebSocketClient webSocketClient() {
        List<Transport> transports = new ArrayList<>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));
        transports.add(new RestTemplateXhrTransport());
        return new SockJsClient(transports);
    }

    public static class Scheduller {

    	protected Log logger = LogFactory.getLog(getClass());

        private @Autowired WebSocketStompClient manager;

        @Scheduled(fixedRate = 3000)
        public void reconnect(){
            
            logger.info("applicationContext "+manager);
        } 
    }
}
