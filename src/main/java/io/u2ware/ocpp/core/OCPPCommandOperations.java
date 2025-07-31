package io.u2ware.ocpp.core;

public interface OCPPCommandOperations<T extends OCPPCommand> {
    
    public void send(T command);
    public void send(String destination, T command) ;
}
