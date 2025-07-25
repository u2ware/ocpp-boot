
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Result of the clear request for this monitor, identified by its Id.
 * 
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum ClearMonitoringStatusEnum {

    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    NOT_FOUND("NotFound");
    private final String value;
    private final static Map<String, ClearMonitoringStatusEnum> CONSTANTS = new HashMap<String, ClearMonitoringStatusEnum>();

    static {
        for (ClearMonitoringStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ClearMonitoringStatusEnum(String value) {
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
    public static ClearMonitoringStatusEnum fromValue(String value) {
        ClearMonitoringStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
