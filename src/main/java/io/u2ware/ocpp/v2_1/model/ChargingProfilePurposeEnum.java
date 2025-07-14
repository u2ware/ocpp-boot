
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Specifies to purpose of the charging profiles that will be cleared, if they meet the other criteria in the request.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum ChargingProfilePurposeEnum {

    CHARGING_STATION_EXTERNAL_CONSTRAINTS("ChargingStationExternalConstraints"),
    CHARGING_STATION_MAX_PROFILE("ChargingStationMaxProfile"),
    TX_DEFAULT_PROFILE("TxDefaultProfile"),
    TX_PROFILE("TxProfile"),
    PRIORITY_CHARGING("PriorityCharging"),
    LOCAL_GENERATION("LocalGeneration");
    private final String value;
    private final static Map<String, ChargingProfilePurposeEnum> CONSTANTS = new HashMap<String, ChargingProfilePurposeEnum>();

    static {
        for (ChargingProfilePurposeEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    ChargingProfilePurposeEnum(String value) {
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
    public static ChargingProfilePurposeEnum fromValue(String value) {
        ChargingProfilePurposeEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
