
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Can be used to force a power or current profile.
 * 
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum ChargingRateUnitEnum {

    W("W"),
    A("A");
    private final String value;
    private final static Map<String, ChargingRateUnitEnum> CONSTANTS = new HashMap<String, ChargingRateUnitEnum>();

    static {
        for (ChargingRateUnitEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ChargingRateUnitEnum(String value) {
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
    public static ChargingRateUnitEnum fromValue(String value) {
        ChargingRateUnitEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
