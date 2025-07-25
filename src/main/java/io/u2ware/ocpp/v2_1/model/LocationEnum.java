
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
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
    OUTLET("Outlet"),
    UPSTREAM("Upstream");
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
