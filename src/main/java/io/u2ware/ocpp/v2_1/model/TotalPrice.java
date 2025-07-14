
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


/**
 * Total cost with and without tax. Contains the total of energy, charging time, idle time, fixed and reservation costs including and/or excluding tax.
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
    "exclTax",
    "inclTax",
    "customData"
})
@Generated("jsonschema2pojo")
public class TotalPrice {

    /**
     * Price/cost excluding tax. Can be absent if _inclTax_ is present.
     * 
     * 
     */
    @JsonProperty("exclTax")
    @JsonPropertyDescription("Price/cost excluding tax. Can be absent if _inclTax_ is present.\r\n")
    private Double exclTax;
    /**
     * Price/cost including tax. Can be absent if _exclTax_ is present.
     * 
     * 
     */
    @JsonProperty("inclTax")
    @JsonPropertyDescription("Price/cost including tax. Can be absent if _exclTax_ is present.\r\n")
    private Double inclTax;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
