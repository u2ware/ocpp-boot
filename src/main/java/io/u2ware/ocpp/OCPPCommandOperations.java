package io.u2ware.ocpp;

public interface OCPPCommandOperations<T extends OCPPCommand> {
    
    public void send(String destination, T command) ;
}
