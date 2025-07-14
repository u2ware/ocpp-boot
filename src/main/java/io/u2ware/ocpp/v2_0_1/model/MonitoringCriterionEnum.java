
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Generated("jsonschema2pojo")
public enum MonitoringCriterionEnum {

    THRESHOLD_MONITORING("ThresholdMonitoring"),
    DELTA_MONITORING("DeltaMonitoring"),
    PERIODIC_MONITORING("PeriodicMonitoring");
    private final String value;
    private final static Map<String, MonitoringCriterionEnum> CONSTANTS = new HashMap<String, MonitoringCriterionEnum>();

    static {
        for (MonitoringCriterionEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    MonitoringCriterionEnum(String value) {
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
    public static MonitoringCriterionEnum fromValue(String value) {
        MonitoringCriterionEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
