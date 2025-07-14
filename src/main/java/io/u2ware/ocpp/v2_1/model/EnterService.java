
package io.u2ware.ocpp.v2_1.model;

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
    "highVoltage",
    "lowVoltage",
    "highFreq",
    "lowFreq",
    "delay",
    "randomDelay",
    "rampRate",
    "customData"
})
@Generated("jsonschema2pojo")
public class EnterService {

    /**
     * Priority of setting (0=highest)
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("Priority of setting (0=highest)\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer priority;
    /**
     * Enter service voltage high
     * 
     * (Required)
     * 
     */
    @JsonProperty("highVoltage")
    @JsonPropertyDescription("Enter service voltage high\r\n")
    @NotNull
    private Double highVoltage;
    /**
     * Enter service voltage low
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("lowVoltage")
    @JsonPropertyDescription("Enter service voltage low\r\n\r\n\r\n")
    @NotNull
    private Double lowVoltage;
    /**
     * Enter service frequency high
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("highFreq")
    @JsonPropertyDescription("Enter service frequency high\r\n\r\n")
    @NotNull
    private Double highFreq;
    /**
     * Enter service frequency low
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("lowFreq")
    @JsonPropertyDescription("Enter service frequency low\r\n\r\n\r\n")
    @NotNull
    private Double lowFreq;
    /**
     * Enter service delay
     * 
     * 
     * 
     * 
     */
    @JsonProperty("delay")
    @JsonPropertyDescription("Enter service delay\r\n\r\n\r\n")
    private Double delay;
    /**
     * Enter service randomized delay
     * 
     * 
     * 
     * 
     */
    @JsonProperty("randomDelay")
    @JsonPropertyDescription("Enter service randomized delay\r\n\r\n\r\n")
    private Double randomDelay;
    /**
     * Enter service ramp rate in seconds
     * 
     * 
     * 
     * 
     */
    @JsonProperty("rampRate")
    @JsonPropertyDescription("Enter service ramp rate in seconds\r\n\r\n\r\n")
    private Double rampRate;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
