
package io.u2ware.ocpp.v2_1.model;

import java.util.List;
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
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
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
    "taxRates",
    "customData"
})
@Generated("jsonschema2pojo")
public class Price {

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
    @JsonProperty("taxRates")
    @Singular("taxRates")
    @Size(min = 1, max = 5)
    @Valid
    private List<TaxRate> taxRates;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
