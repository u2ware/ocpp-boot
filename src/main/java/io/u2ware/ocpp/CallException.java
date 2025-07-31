package io.u2ware.ocpp;

import org.springframework.util.ClassUtils;

public abstract class CallException extends RuntimeException{
    
    private String description;
    private Object details;

    protected CallException(String code, String description, Object details){
        super(code, ClassUtils.isAssignableValue(Throwable.class, details) ? (Throwable)details : null);
        this.description = description;
        this.details = ClassUtils.isAssignableValue(Throwable.class, details) ? null : details;
    }

    public String getCode() {
        return getMessage();
    }

    public String getDescription() {
        return description;
    }

    public Object getDetails() {
        return details != null ? details : getCause();
    }
}

