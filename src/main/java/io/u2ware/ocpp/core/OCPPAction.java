package io.u2ware.ocpp.core;

import java.util.Map;

public interface OCPPAction {

    public Map<String, Object> getAttributes();
    public String getUsecase() ;
    public String getAction();
    public String getIdentifier();
}