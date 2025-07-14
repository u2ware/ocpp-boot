package io.u2ware.ocpp.config;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

import io.u2ware.ocpp.core.OCPPWebsocketHandler;

@EnableWebSocket
class WebSocketStandardServerConfiguration implements WebSocketConfigurer {

	protected Log logger = LogFactory.getLog(getClass());

	public static final String ENDPOINT = "/ocpp";  //"Invalid SockJS path '/websocket/info' - required to have 3 path segments"

    protected @Autowired OcppAttributes ocppAttributes;
    protected @Autowired OCPPWebsocketHandler<?> websocketHandler;


	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		registry.addHandler(websocketHandler, ENDPOINT)
			// .setAllowedOrigins("*")
			.setAllowedOriginPatterns("*")
			.addInterceptors(new HandshakeInterceptor(){

				@Override
				public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
						WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
					return true;
				}

				@Override
				public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
						WebSocketHandler wsHandler, Exception exception) {
					
				}


			})
			.withSockJS()
		;
	}
}
