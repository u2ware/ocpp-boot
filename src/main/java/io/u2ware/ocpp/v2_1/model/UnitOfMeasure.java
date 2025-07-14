
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Represents a UnitOfMeasure with a multiplier
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
    "unit",
    "multiplier",
    "customData"
})
@Generated("jsonschema2pojo")
public class UnitOfMeasure {

    /**
     * Unit of the value. Default = "Wh" if the (default) measurand is an "Energy" type.
     * This field SHALL use a value from the list Standardized Units of Measurements in Part 2 Appendices. 
     * If an applicable unit is available in that list, otherwise a "custom" unit might be used.
     * 
     * 
     */
    @JsonProperty("unit")
    @JsonPropertyDescription("Unit of the value. Default = \"Wh\" if the (default) measurand is an \"Energy\" type.\r\nThis field SHALL use a value from the list Standardized Units of Measurements in Part 2 Appendices. \r\nIf an applicable unit is available in that list, otherwise a \"custom\" unit might be used.\r\n")
    @lombok.Builder.Default
    @Size(max = 20)
    private String unit = "Wh";
    /**
     * Multiplier, this value represents the exponent to base 10. I.e. multiplier 3 means 10 raised to the 3rd power. Default is 0. +
     * The _multiplier_ only multiplies the value of the measurand. It does not specify a conversion between units, for example, kW and W.
     * 
     * 
     */
    @JsonProperty("multiplier")
    @JsonPropertyDescription("Multiplier, this value represents the exponent to base 10. I.e. multiplier 3 means 10 raised to the 3rd power. Default is 0. +\r\nThe _multiplier_ only multiplies the value of the measurand. It does not specify a conversion between units, for example, kW and W.\r\n")
    @lombok.Builder.Default
    private Integer multiplier = 0;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
