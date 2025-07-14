
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * The updated reservation status.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum ReservationUpdateStatusEnum {

    EXPIRED("Expired"),
    REMOVED("Removed"),
    NO_TRANSACTION("NoTransaction");
    private final String value;
    private final static Map<String, ReservationUpdateStatusEnum> CONSTANTS = new HashMap<String, ReservationUpdateStatusEnum>();

    static {
        for (ReservationUpdateStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ReservationUpdateStatusEnum(String value) {
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
    public static ReservationUpdateStatusEnum fromValue(String value) {
        ReservationUpdateStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
