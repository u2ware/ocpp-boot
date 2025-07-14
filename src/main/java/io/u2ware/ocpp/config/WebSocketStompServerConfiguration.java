package io.u2ware.ocpp.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;


@EnableWebSocketMessageBroker
public class WebSocketStompServerConfiguration implements WebSocketMessageBrokerConfigurer {

    protected Log logger = LogFactory.getLog(getClass());

    public static final String WS_CONNECTION    = "/console";  //sockjs '/ocpp1.6/websocket'
    public static final String WS_BROADCASTING  = "/app/";
    public static final String WS_SUBSCRIPTIONS = "/topic/";


    protected @Autowired OcppAttributes attributes;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // System.err.println("registerStompEndpoints");

        registry.addEndpoint(WS_CONNECTION)
                .setAllowedOriginPatterns("*")
                .withSockJS()
                ;
    }


    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        // System.err.println("configureWebSocketTransport");
        registration.setMessageSizeLimit(10 * 1024);
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // System.err.println("configureMessageBroker");

        registry.setApplicationDestinationPrefixes(WS_BROADCASTING); //app


        logger.info("Enable Simple Broker");
        registry.enableSimpleBroker(WS_SUBSCRIPTIONS); //topic
        return;


        // ///////////////////////////////////////////
        // // Enables a simple in-memory broker
        // ///////////////////////////////////////////
        // if(! stompBrokerRelayProperties().available()) {
        //     logger.info("Enable Simple Broker");
        //     registry.enableSimpleBroker(WS_SUBSCRIPTIONS); //topic
        //     return;
        // }

        // ///////////////////////////////////////////
        // // Enable STOMP MessageQueue broker
        // ///////////////////////////////////////////
        // logger.info("Enable Stomp Broker Relay");
        // registry.enableStompBrokerRelay(WS_SUBSCRIPTIONS)//topic
        //         .setRelayHost(stompBrokerRelayProperties().getHost())
		//         .setRelayPort(stompBrokerRelayProperties().getPort())
        //         .setSystemLogin(stompBrokerRelayProperties().getUsername())
        //         .setSystemPasscode(stompBrokerRelayProperties().getPassword())
		//         .setClientLogin(stompBrokerRelayProperties().getUsername())
		//         .setClientPasscode(stompBrokerRelayProperties().getPassword())
        // ;
    }

    // @Bean
    // protected StompBrokerRelayProperties stompBrokerRelayProperties(){
    //     return new StompBrokerRelayProperties();
    // }

    // @Bean
    // protected Xyz XyzXyzXyzXyzXyzXyzXyzXyz(){
    //     return new Xyz();
    // }




}
