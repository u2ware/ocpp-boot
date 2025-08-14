package io.u2ware.ocpp.test.base00;

public interface Handler {

    
    // String usecase();
    // Boolean action();

    default String usecase(){
        return null;
    }
    default Boolean action(){
        return Boolean.TRUE;
    }
}
