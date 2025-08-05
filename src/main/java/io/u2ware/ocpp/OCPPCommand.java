package io.u2ware.ocpp;

import java.util.Map;

import org.springframework.util.ClassUtils;

public abstract class OCPPCommand {

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

    @Override
    public String toString() {
        return ClassUtils.getQualifiedName(getClass())+" [attributes=" + attributes + ", usecase=" + usecase + ", action=" + action + ", identifier="
                + identifier + "]";
    }
}