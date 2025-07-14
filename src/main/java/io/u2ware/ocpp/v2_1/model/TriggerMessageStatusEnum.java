
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Indicates whether the Charging Station will send the requested notification or not.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum TriggerMessageStatusEnum {

    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    NOT_IMPLEMENTED("NotImplemented");
    private final String value;
    private final static Map<String, TriggerMessageStatusEnum> CONSTANTS = new HashMap<String, TriggerMessageStatusEnum>();

    static {
        for (TriggerMessageStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    TriggerMessageStatusEnum(String value) {
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
    public static TriggerMessageStatusEnum fromValue(String value) {
        TriggerMessageStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
