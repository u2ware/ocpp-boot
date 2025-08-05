package io.u2ware.ocpp.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import io.u2ware.ocpp.OCPPSessionTemplate;
import io.u2ware.ocpp.client.WebsocketStandardConnectionManager;


@Configuration
@EnableScheduling
public class WebSocketStandardClientConfiguration {
    
	protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired OcppAttributes ocppAttributes;
    protected @Autowired OCPPSessionTemplate<?> websocketHandler;


    @Bean
    public WebsocketStandardConnectionManager webSocketConnectionManager() {
        String url = ocppAttributes.getUri();
        return new WebsocketStandardConnectionManager(webSocketClient(), websocketHandler, url);
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

        protected @Autowired WebsocketStandardConnectionManager manager;

        @Scheduled(fixedRate = 3000, initialDelay=1000)
        public void reconnect() throws Exception{

            if(! manager.isOpen()) {
                manager.open();
            }
        }
    }
}