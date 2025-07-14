
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
    "overFreq",
    "underFreq",
    "overDroop",
    "underDroop",
    "responseTime",
    "startTime",
    "duration",
    "customData"
})
@Generated("jsonschema2pojo")
public class FreqDroop {

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
     * Over-frequency start of droop
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("overFreq")
    @JsonPropertyDescription("Over-frequency start of droop\r\n\r\n\r\n")
    @NotNull
    private Double overFreq;
    /**
     * Under-frequency start of droop
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("underFreq")
    @JsonPropertyDescription("Under-frequency start of droop\r\n\r\n\r\n")
    @NotNull
    private Double underFreq;
    /**
     * Over-frequency droop per unit, oFDroop
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("overDroop")
    @JsonPropertyDescription("Over-frequency droop per unit, oFDroop\r\n\r\n\r\n")
    @NotNull
    private Double overDroop;
    /**
     * Under-frequency droop per unit, uFDroop
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("underDroop")
    @JsonPropertyDescription("Under-frequency droop per unit, uFDroop\r\n\r\n")
    @NotNull
    private Double underDroop;
    /**
     * Open loop response time in seconds
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("responseTime")
    @JsonPropertyDescription("Open loop response time in seconds\r\n\r\n")
    @NotNull
    private Double responseTime;
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
