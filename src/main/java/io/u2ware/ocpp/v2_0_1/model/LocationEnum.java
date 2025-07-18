
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Sampled_ Value. Location. Location_ Code
 * urn:x-oca:ocpp:uid:1:569265
 * Indicates where the measured value has been sampled. Default =  "Outlet"
 * 
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum LocationEnum {

    BODY("Body"),
    CABLE("Cable"),
    EV("EV"),
    INLET("Inlet"),
    OUTLET("Outlet");
    private final String value;
    private final static Map<String, LocationEnum> CONSTANTS = new HashMap<String, LocationEnum>();

    static {
        for (LocationEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    LocationEnum(String value) {
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
    public static LocationEnum fromValue(String value) {
        LocationEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
