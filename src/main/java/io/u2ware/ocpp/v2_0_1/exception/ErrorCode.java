package io.u2ware.ocpp.v2_0_1.exception;

import io.u2ware.ocpp.core.CallException;

public final class ErrorCode extends CallException{

    ErrorCode(String code, String description, Object details) {
        super(code, description, details);
    }
}
