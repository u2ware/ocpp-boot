package io.u2ware.ocpp;

import java.util.function.BiConsumer;

public interface OCPPConsumer<T> extends BiConsumer<T, Throwable> {
    
}
