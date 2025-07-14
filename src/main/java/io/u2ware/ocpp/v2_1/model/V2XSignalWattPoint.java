
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * *(2.1)* A point of a signal-watt curve.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "signal",
    "power",
    "customData"
})
@Generated("jsonschema2pojo")
public class V2XSignalWattPoint {

    /**
     * Signal value from an AFRRSignalRequest.
     * 
     * (Required)
     * 
     */
    @JsonProperty("signal")
    @JsonPropertyDescription("Signal value from an AFRRSignalRequest.\r\n")
    @NotNull
    private Integer signal;
    /**
     * Power in W to charge (positive) or discharge (negative) at specified frequency.
     * 
     * (Required)
     * 
     */
    @JsonProperty("power")
    @JsonPropertyDescription("Power in W to charge (positive) or discharge (negative) at specified frequency.\r\n")
    @NotNull
    private Double power;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
