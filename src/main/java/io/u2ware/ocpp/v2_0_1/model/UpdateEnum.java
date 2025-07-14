
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * This contains the type of update (full or differential) of this request.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum UpdateEnum {

    DIFFERENTIAL("Differential"),
    FULL("Full");
    private final String value;
    private final static Map<String, UpdateEnum> CONSTANTS = new HashMap<String, UpdateEnum>();

    static {
        for (UpdateEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    UpdateEnum(String value) {
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
    public static UpdateEnum fromValue(String value) {
        UpdateEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
