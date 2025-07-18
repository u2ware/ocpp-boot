
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * This indicates whether the Charging Station is able to perform the availability change.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum ChangeAvailabilityStatusEnum {

    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    SCHEDULED("Scheduled");
    private final String value;
    private final static Map<String, ChangeAvailabilityStatusEnum> CONSTANTS = new HashMap<String, ChangeAvailabilityStatusEnum>();

    static {
        for (ChangeAvailabilityStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ChangeAvailabilityStatusEnum(String value) {
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
    public static ChangeAvailabilityStatusEnum fromValue(String value) {
        ChangeAvailabilityStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
