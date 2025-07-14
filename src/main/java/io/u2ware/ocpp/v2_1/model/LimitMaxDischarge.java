
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    "priority",
    "pctMaxDischargePower",
    "powerMonitoringMustTrip",
    "startTime",
    "duration",
    "customData"
})
@Generated("jsonschema2pojo")
public class LimitMaxDischarge {

    /**
     * Priority of setting (0=highest)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("Priority of setting (0=highest)\r\n\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer priority;
    /**
     * Only for PowerMonitoring. +
     *     The value specifies a percentage (0 to 100) of the rated maximum discharge power of EV. 
     *     The PowerMonitoring curve becomes active when power exceeds this percentage.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("pctMaxDischargePower")
    @JsonPropertyDescription("Only for PowerMonitoring. +\r\n    The value specifies a percentage (0 to 100) of the rated maximum discharge power of EV. \r\n    The PowerMonitoring curve becomes active when power exceeds this percentage.\r\n\r\n\r\n")
    private Double pctMaxDischargePower;
    @JsonProperty("powerMonitoringMustTrip")
    @Valid
    private DERCurve powerMonitoringMustTrip;
    /**
     * Time when this setting becomes active
     * 
     * 
     * 
     * 
     */
    @JsonProperty("startTime")
    @JsonPropertyDescription("Time when this setting becomes active\r\n\r\n\r\n")
    private ZonedDateTime startTime;
    /**
     * Duration in seconds that this setting is active
     * 
     * 
     * 
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Duration in seconds that this setting is active\r\n\r\n\r\n")
    private Double duration;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
