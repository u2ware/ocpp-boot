
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Accepted if the Charging Station has executed the request, otherwise rejected.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum ClearCacheStatusEnum {

    ACCEPTED("Accepted"),
    REJECTED("Rejected");
    private final String value;
    private final static Map<String, ClearCacheStatusEnum> CONSTANTS = new HashMap<String, ClearCacheStatusEnum>();

    static {
        for (ClearCacheStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ClearCacheStatusEnum(String value) {
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
    public static ClearCacheStatusEnum fromValue(String value) {
        ClearCacheStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
