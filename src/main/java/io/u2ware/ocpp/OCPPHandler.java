package io.u2ware.ocpp;

public interface OCPPHandler {
    
	// public String[] features(); // features is usecase or action

    default String usecase(){
        return null;
    }
    default Boolean actions(){
        return Boolean.TRUE;
    }
	
}
