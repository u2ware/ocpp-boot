package io.u2ware.ocpp;

public enum CallType {

    Call(2,4),
    CallResult(3,3),
    CallError(4,5),
    ;

    private int type;
    private int size;
    
    CallType(int type, int size){
        this.type = type;
        this.size = size;
    }
    public int type(){
        return type;
    }
    public int size(){
        return size;
    }

    public boolean correct(OCPPMessage<?> msg) {
        if(msg == null || msg.getType() == null) return false;
        return msg.getType().type() == type();
    }
    public boolean correct(int type , int size) {
        return type() == type && size() <= size;
    }
}

