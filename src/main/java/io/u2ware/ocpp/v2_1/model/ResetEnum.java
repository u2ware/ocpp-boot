
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * This contains the type of reset that the Charging Station or EVSE should perform.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum ResetEnum {

    IMMEDIATE("Immediate"),
    ON_IDLE("OnIdle"),
    IMMEDIATE_AND_RESUME("ImmediateAndResume");
    private final String value;
    private final static Map<String, ResetEnum> CONSTANTS = new HashMap<String, ResetEnum>();

    static {
        for (ResetEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ResetEnum(String value) {
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
    public static ResetEnum fromValue(String value) {
        ResetEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
