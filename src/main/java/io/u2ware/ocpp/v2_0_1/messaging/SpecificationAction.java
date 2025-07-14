package io.u2ware.ocpp.v2_0_1.messaging;

import java.util.Map;

import io.u2ware.ocpp.core.OCPPAction;

public class SpecificationAction implements OCPPAction{

    private Map<String,Object> attributes;
    private String usecase;
    private String action;
    private String identifier;
    
    public Map<String, Object> getAttributes() {
        return attributes;
    }
    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
    public String getUsecase() {
        return usecase;
    }
    public void setUsecase(String usecase) {
        this.usecase = usecase;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getIdentifier() {
        return identifier;
    }
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
