package io.u2ware.ocpp.v2_0_1.exception;

import java.util.HashMap;

public enum ErrorCodes  {

    FormatViolation("Payload for Action is syntactically incorrect"),
    GenericError("Any other error not covered by the more specific error codes in this table"),
    InternalError(" An internal error occurred and the receiver was not able to process the requested Action successfully"),
    MessageTypeNotSupported(" A message with an Message Type Number received that is not supported by this implementation."),
    NotImplemented(" Requested Action is not known by receiver"),
    NotSupported(" Requested Action is recognized but not supported by the receiver"),
    OccurrenceConstraintViolation(" Payload for Action is syntactically correct but at least one of the fields violates occurrence constraints"),
    PropertyConstraintViolation(" Payload is syntactically correct but at least one field contains an invalid value"),
    ProtocolError(" Payload for Action is not conform the PDU structure"),
    RpcFrameworkError(" Content of the call is not a valid RPC Request, for example: MessageId could not be read."),
    SecurityError(" During the processing of Action a security issue occurred preventing receiver from completing the Action successfully"),
    TypeConstraintViolation(" Payload for Action is syntactically correct but at least one of the fields violates data type constraints (e.g. \"somestring\": 12)"),

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