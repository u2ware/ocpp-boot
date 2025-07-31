package io.u2ware.ocpp;

public interface OCPPFeatureOperations<T extends OCPPCommand> {
    
    public void offer(T source, OCPPConsumer<OCPPMessage<?>> consumer) ;
    public void answer(OCPPMessage<?> source, OCPPConsumer<OCPPMessage<?>> consumer) ;

    public String name();
    public boolean isServer();
    public boolean isClient();
    public OCPPVersion version();


}