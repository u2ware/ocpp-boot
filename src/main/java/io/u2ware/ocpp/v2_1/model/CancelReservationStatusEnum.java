
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * This indicates the success or failure of the canceling of a reservation by CSMS.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum CancelReservationStatusEnum {

    ACCEPTED("Accepted"),
    REJECTED("Rejected");
    private final String value;
    private final static Map<String, CancelReservationStatusEnum> CONSTANTS = new HashMap<String, CancelReservationStatusEnum>();

    static {
        for (CancelReservationStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    CancelReservationStatusEnum(String value) {
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
    public static CancelReservationStatusEnum fromValue(String value) {
        CancelReservationStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
