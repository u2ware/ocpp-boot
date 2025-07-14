
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * *(2.1)* Charging operation mode to use during this time interval. When absent defaults to `ChargingOnly`.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum OperationModeEnum {

    IDLE("Idle"),
    CHARGING_ONLY("ChargingOnly"),
    CENTRAL_SETPOINT("CentralSetpoint"),
    EXTERNAL_SETPOINT("ExternalSetpoint"),
    EXTERNAL_LIMITS("ExternalLimits"),
    CENTRAL_FREQUENCY("CentralFrequency"),
    LOCAL_FREQUENCY("LocalFrequency"),
    LOCAL_LOAD_BALANCING("LocalLoadBalancing");
    private final String value;
    private final static Map<String, OperationModeEnum> CONSTANTS = new HashMap<String, OperationModeEnum>();

    static {
        for (OperationModeEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    OperationModeEnum(String value) {
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
    public static OperationModeEnum fromValue(String value) {
        OperationModeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
