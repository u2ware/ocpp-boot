
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Defines the mutability of this attribute. Default is ReadWrite when omitted.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum MutabilityEnum {

    READ_ONLY("ReadOnly"),
    WRITE_ONLY("WriteOnly"),
    READ_WRITE("ReadWrite");
    private final String value;
    private final static Map<String, MutabilityEnum> CONSTANTS = new HashMap<String, MutabilityEnum>();

    static {
        for (MutabilityEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    MutabilityEnum(String value) {
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
    public static MutabilityEnum fromValue(String value) {
        MutabilityEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
