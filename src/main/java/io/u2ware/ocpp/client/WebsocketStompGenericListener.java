package io.u2ware.ocpp.client;

import org.springframework.messaging.simp.stomp.StompHeaders;

@FunctionalInterface
public interface WebsocketStompGenericListener<T> {
    public void handle(StompHeaders header, T payload);
}
