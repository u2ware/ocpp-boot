package io.u2ware.ocpp.client;

import java.lang.reflect.Type;

import org.springframework.core.GenericTypeResolver;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

public abstract class WebsocketStompGenericHandler<T> implements StompFrameHandler {

    private final Class<?> INTERESTED_TYPE = GenericTypeResolver.resolveTypeArgument(getClass(), WebsocketStompGenericHandler.class);

    @Override
    public Type getPayloadType(StompHeaders headers) {
        // System.err.println("getPayloadType"+headers);
        // System.err.println("getPayloadType"+INTERESTED_TYPE);
        return INTERESTED_TYPE;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void handleFrame(StompHeaders headers, Object payload) {
        // System.err.println("handleFrame"+headers);        
        handle(headers, (T)payload);
    }

    public abstract void handle(StompHeaders header, T payload);
}