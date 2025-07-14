
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Type of EVSE (AC, DC) this tariff applies to.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum EvseKindEnum {

    AC("AC"),
    DC("DC");
    private final String value;
    private final static Map<String, EvseKindEnum> CONSTANTS = new HashMap<String, EvseKindEnum>();

    static {
        for (EvseKindEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    EvseKindEnum(String value) {
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
    public static EvseKindEnum fromValue(String value) {
        EvseKindEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
