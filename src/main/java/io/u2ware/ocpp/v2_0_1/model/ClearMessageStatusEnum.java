
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Returns whether the Charging Station has been able to remove the message.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum ClearMessageStatusEnum {

    ACCEPTED("Accepted"),
    UNKNOWN("Unknown");
    private final String value;
    private final static Map<String, ClearMessageStatusEnum> CONSTANTS = new HashMap<String, ClearMessageStatusEnum>();

    static {
        for (ClearMessageStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ClearMessageStatusEnum(String value) {
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
    public static ClearMessageStatusEnum fromValue(String value) {
        ClearMessageStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
