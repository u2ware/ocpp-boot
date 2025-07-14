
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Indicates if the Charging Station was able to execute the request.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum ClearChargingProfileStatusEnum {

    ACCEPTED("Accepted"),
    UNKNOWN("Unknown");
    private final String value;
    private final static Map<String, ClearChargingProfileStatusEnum> CONSTANTS = new HashMap<String, ClearChargingProfileStatusEnum>();

    static {
        for (ClearChargingProfileStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ClearChargingProfileStatusEnum(String value) {
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
    public static ClearChargingProfileStatusEnum fromValue(String value) {
        ClearChargingProfileStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
