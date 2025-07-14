package io.u2ware.ocpp.core;

public class CallError<T extends CallException> extends OCPPMessage<T>  {
 
    // public Integer type = 4;
    // public String id;

    // public String errorCode;
    // public String errorDescription;
    // public Object errorDetail;

    public CallType getType() {
        return CallType.CallError;
    }
}