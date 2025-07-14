
package io.u2ware.ocpp.v1_6.model;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "duration",
    "startSchedule",
    "chargingRateUnit",
    "chargingSchedulePeriod",
    "minChargingRate"
})
@Generated("jsonschema2pojo")
public class ChargingSchedule {

    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("startSchedule")
    private ZonedDateTime startSchedule;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    @NotNull
    private ChargingSchedule.ChargingRateUnit chargingRateUnit;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    @Singular("chargingSchedulePeriod")
    @Valid
    @NotNull
    private List<ChargingSchedulePeriod> chargingSchedulePeriod;
    @JsonProperty("minChargingRate")
    private Double minChargingRate;

    @Generated("jsonschema2pojo")
    public enum ChargingRateUnit {

        A("A"),
        W("W");
        private final String value;
        private final static Map<String, ChargingSchedule.ChargingRateUnit> CONSTANTS = new HashMap<String, ChargingSchedule.ChargingRateUnit>();

        static {
            for (ChargingSchedule.ChargingRateUnit c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        ChargingRateUnit(String value) {
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
        public static ChargingSchedule.ChargingRateUnit fromValue(String value) {
            ChargingSchedule.ChargingRateUnit constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
