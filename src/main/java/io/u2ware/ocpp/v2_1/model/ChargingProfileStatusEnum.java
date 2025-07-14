
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Result of request.
 * 
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum ChargingProfileStatusEnum {

    ACCEPTED("Accepted"),
    REJECTED("Rejected");
    private final String value;
    private final static Map<String, ChargingProfileStatusEnum> CONSTANTS = new HashMap<String, ChargingProfileStatusEnum>();

    static {
        for (ChargingProfileStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ChargingProfileStatusEnum(String value) {
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
    public static ChargingProfileStatusEnum fromValue(String value) {
        ChargingProfileStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
