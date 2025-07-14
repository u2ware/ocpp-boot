
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * This contains the type of log file that the Charging Station
 * should send.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum LogEnum {

    DIAGNOSTICS_LOG("DiagnosticsLog"),
    SECURITY_LOG("SecurityLog"),
    DATA_COLLECTOR_LOG("DataCollectorLog");
    private final String value;
    private final static Map<String, LogEnum> CONSTANTS = new HashMap<String, LogEnum>();

    static {
        for (LogEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    LogEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    @JsonValue
    public String value() {
        return this.value;
    }

    @JsonCreator
    public static LogEnum fromValue(String value) {
        LogEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
