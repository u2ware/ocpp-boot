
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Attribute type for which value is requested. When absent, default Actual is assumed.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum AttributeEnum {

    ACTUAL("Actual"),
    TARGET("Target"),
    MIN_SET("MinSet"),
    MAX_SET("MaxSet");
    private final String value;
    private final static Map<String, AttributeEnum> CONSTANTS = new HashMap<String, AttributeEnum>();

    static {
        for (AttributeEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    AttributeEnum(String value) {
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
    public static AttributeEnum fromValue(String value) {
        AttributeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
