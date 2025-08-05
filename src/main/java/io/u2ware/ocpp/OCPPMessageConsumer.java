package io.u2ware.ocpp;

import java.util.function.BiConsumer;

public interface OCPPMessageConsumer extends BiConsumer<OCPPMessage<?>, Throwable> {
    
}
