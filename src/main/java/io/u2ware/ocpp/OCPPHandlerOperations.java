package io.u2ware.ocpp;

public interface OCPPHandlerOperations<T extends OCPPCommand> {
    
    public void offer(T source, OCPPMessageConsumer consumer) ;
    public void answer(OCPPMessage<?> source, OCPPMessageConsumer consumer) ;

    public String name();
    public boolean isServer();
    public boolean isClient();
    public OCPPVersion version();
}