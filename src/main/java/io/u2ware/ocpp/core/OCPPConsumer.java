package io.u2ware.ocpp.core;

import java.util.function.BiConsumer;

public interface OCPPConsumer<T> extends BiConsumer<T, Throwable> {
    
}
