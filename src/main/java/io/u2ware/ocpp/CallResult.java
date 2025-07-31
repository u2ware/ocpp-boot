package io.u2ware.ocpp;

public class CallResult<T> extends OCPPMessage<T> {

    // public Integer type = 3;
    // public String id;
    // public T payload;

    public CallType getType() {
        return CallType.CallResult;
    }

}
