
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
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
    "hysteresisHigh",
    "hysteresisLow",
    "hysteresisDelay",
    "hysteresisGradient",
    "customData"
})
@Generated("jsonschema2pojo")
public class Hysteresis {

    /**
     * High value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisHigh")
    @JsonPropertyDescription("High value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit\r\n\r\n\r\n")
    private Double hysteresisHigh;
    /**
     * Low value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisLow")
    @JsonPropertyDescription("Low value for return to normal operation after a grid event, in absolute value. This value adopts the same unit as defined by yUnit\r\n\r\n\r\n")
    private Double hysteresisLow;
    /**
     * Delay in seconds, once grid parameter within HysteresisLow and HysteresisHigh, for the EV to return to normal operation after a grid event.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisDelay")
    @JsonPropertyDescription("Delay in seconds, once grid parameter within HysteresisLow and HysteresisHigh, for the EV to return to normal operation after a grid event.\r\n\r\n\r\n")
    private Double hysteresisDelay;
    /**
     * Set default rate of change (ramp rate %/s) for the EV to return to normal operation after a grid event
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hysteresisGradient")
    @JsonPropertyDescription("Set default rate of change (ramp rate %/s) for the EV to return to normal operation after a grid event\r\n\r\n\r\n")
    private Double hysteresisGradient;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
