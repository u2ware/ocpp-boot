package io.u2ware.ocpp.v2_1.exception;

import io.u2ware.ocpp.CallException;

public final class ErrorCode extends CallException{

    ErrorCode(String code, String description, Object details) {
        super(code, description, details);
    }
}
