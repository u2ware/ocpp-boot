
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * This indicates the success or failure of the reservation.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum ReserveNowStatusEnum {

    ACCEPTED("Accepted"),
    FAULTED("Faulted"),
    OCCUPIED("Occupied"),
    REJECTED("Rejected"),
    UNAVAILABLE("Unavailable");
    private final String value;
    private final static Map<String, ReserveNowStatusEnum> CONSTANTS = new HashMap<String, ReserveNowStatusEnum>();

    static {
        for (ReserveNowStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ReserveNowStatusEnum(String value) {
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
    public static ReserveNowStatusEnum fromValue(String value) {
        ReserveNowStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
