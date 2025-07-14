package io.u2ware.ocpp.v1_6.exception;

import java.util.HashMap;

public enum ErrorCodes {

    NotImplemented("Requested Action is not known by receiver "),
    NotSupported(" Requested Action is recognized but not supported by the receiver"),
    InternalError(" An internal error occurred and the receiver was not able to process the requested Action successfully"),
    ProtocolError(" Payload for Action is incomplete "),
    SecurityError(" During the processing of Action a security issue occurred preventing receiver from completing the Action successfully"),
    FormationViolation(" Payload for Action is syntactically incorrect or not conform the PDU structure for Action"),
    PropertyConstraintViolation(" Payload is syntactically correct but at least one field contains an invalid value"),
    OccurenceConstraintViolation(" Payload for Action is syntactically correct but at least one of the fields violates occurence constraints"),
    TypeConstraintViolation(" Payload for Action is syntactically correct but at least one of the fields violates data type constraints (e.g. somestring: 12)"),
    GenericError(" Any other error not covered by the previous ones"),
   
    ;
    private String description;

    ErrorCodes(String description){
        this.description = description;
    }


    public ErrorCode exception() {
        return new ErrorCode(name(), description, new HashMap<>());
    }
    public ErrorCode exception(Object details) {
        return new ErrorCode(name(), description, details);
    }
    public ErrorCode exception(String description) {
        return new ErrorCode(name(), description, new HashMap<>());
    }
    public ErrorCode exception(String description, Object details) {
        return new ErrorCode(name(), description, details);
    }
}