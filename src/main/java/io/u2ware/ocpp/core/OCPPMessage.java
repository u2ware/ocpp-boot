package io.u2ware.ocpp.core;

public abstract class OCPPMessage<T> {

    private String id;
    private T payload;

    public CallType getType() {
        return null;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public T getPayload() {
        return payload;
    }
    public void setPayload(T payload) {
        this.payload = payload;
    } 

}
