package io.u2ware.ocpp;

import java.util.Map;

public interface OCPPCommand {

    public Map<String, Object> getAttributes();
    public String getUsecase();
    public String getAction();
    public String getIdentifier();
}