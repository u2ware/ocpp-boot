
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Result of the request.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum PriorityChargingStatusEnum {

    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    NO_PROFILE("NoProfile");
    private final String value;
    private final static Map<String, PriorityChargingStatusEnum> CONSTANTS = new HashMap<String, PriorityChargingStatusEnum>();

    static {
        for (PriorityChargingStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    PriorityChargingStatusEnum(String value) {
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
    public static PriorityChargingStatusEnum fromValue(String value) {
        PriorityChargingStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
