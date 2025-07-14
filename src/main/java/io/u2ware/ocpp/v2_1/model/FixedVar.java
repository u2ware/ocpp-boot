
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
    "setpoint",
    "unit",
    "startTime",
    "duration",
    "customData"
})
@Generated("jsonschema2pojo")
public class FixedVar {

    /**
     * Priority of setting (0=highest)
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("Priority of setting (0=highest)\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer priority;
    /**
     * The value specifies a target var output interpreted as a signed percentage (-100 to 100). 
     *     A negative value refers to charging, whereas a positive one refers to discharging.
     *     The value type is determined by the unit field.
     * 
     * (Required)
     * 
     */
    @JsonProperty("setpoint")
    @JsonPropertyDescription("The value specifies a target var output interpreted as a signed percentage (-100 to 100). \r\n    A negative value refers to charging, whereas a positive one refers to discharging.\r\n    The value type is determined by the unit field.\r\n")
    @NotNull
    private Double setpoint;
    /**
     * Unit of the Y-axis of DER curve
     * 
     * (Required)
     * 
     */
    @JsonProperty("unit")
    @JsonPropertyDescription("Unit of the Y-axis of DER curve\r\n")
    @NotNull
    private DERUnitEnum unit;
    /**
     * Time when this setting becomes active.
     * 
     * 
     */
    @JsonProperty("startTime")
    @JsonPropertyDescription("Time when this setting becomes active.\r\n")
    private ZonedDateTime startTime;
    /**
     * Duration in seconds that this setting is active.
     * 
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Duration in seconds that this setting is active.\r\n")
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
