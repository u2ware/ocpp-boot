
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
    "gradient",
    "softGradient",
    "customData"
})
@Generated("jsonschema2pojo")
public class Gradient {

    /**
     * Id of setting
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("Id of setting\r\n\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer priority;
    /**
     * Default ramp rate in seconds (0 if not applicable)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("gradient")
    @JsonPropertyDescription("Default ramp rate in seconds (0 if not applicable)\r\n\r\n\r\n")
    @NotNull
    private Double gradient;
    /**
     * Soft-start ramp rate in seconds (0 if not applicable)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("softGradient")
    @JsonPropertyDescription("Soft-start ramp rate in seconds (0 if not applicable)\r\n\r\n\r\n")
    @NotNull
    private Double softGradient;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
