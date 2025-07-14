
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * This indicates whether the Charging Station has successfully received and applied the update of the Local Authorization List.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum SendLocalListStatusEnum {

    ACCEPTED("Accepted"),
    FAILED("Failed"),
    VERSION_MISMATCH("VersionMismatch");
    private final String value;
    private final static Map<String, SendLocalListStatusEnum> CONSTANTS = new HashMap<String, SendLocalListStatusEnum>();

    static {
        for (SendLocalListStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    SendLocalListStatusEnum(String value) {
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
    public static SendLocalListStatusEnum fromValue(String value) {
        SendLocalListStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
