
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Indicates the kind of schedule.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum ChargingProfileKindEnum {

    ABSOLUTE("Absolute"),
    RECURRING("Recurring"),
    RELATIVE("Relative"),
    DYNAMIC("Dynamic");
    private final String value;
    private final static Map<String, ChargingProfileKindEnum> CONSTANTS = new HashMap<String, ChargingProfileKindEnum>();

    static {
        for (ChargingProfileKindEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ChargingProfileKindEnum(String value) {
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
    public static ChargingProfileKindEnum fromValue(String value) {
        ChargingProfileKindEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
