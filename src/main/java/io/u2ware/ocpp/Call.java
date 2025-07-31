package io.u2ware.ocpp;

public class Call<T> extends OCPPMessage<T> {
    
    // public Integer type = 2;
    // public String id;

    public String action;
    // public T payload;

    public CallType getType() {
        return CallType.Call;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
   
}