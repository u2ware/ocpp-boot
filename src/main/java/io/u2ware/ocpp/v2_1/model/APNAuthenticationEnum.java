
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Authentication method.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum APNAuthenticationEnum {

    PAP("PAP"),
    CHAP("CHAP"),
    NONE("NONE"),
    AUTO("AUTO");
    private final String value;
    private final static Map<String, APNAuthenticationEnum> CONSTANTS = new HashMap<String, APNAuthenticationEnum>();

    static {
        for (APNAuthenticationEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    APNAuthenticationEnum(String value) {
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
    public static APNAuthenticationEnum fromValue(String value) {
        APNAuthenticationEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
