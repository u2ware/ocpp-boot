
package io.u2ware.ocpp.v2_0_1.model;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Sales_ Tariff_ Entry
 * urn:x-oca:ocpp:uid:2:233271
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
    "customData",
    "relativeTimeInterval",
    "ePriceLevel",
    "consumptionCost"
})
@Generated("jsonschema2pojo")
public class SalesTariffEntry {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Relative_ Timer_ Interval
     * urn:x-oca:ocpp:uid:2:233270
     * 
     * (Required)
     * 
     */
    @JsonProperty("relativeTimeInterval")
    @JsonPropertyDescription("Relative_ Timer_ Interval\r\nurn:x-oca:ocpp:uid:2:233270\r\n")
    @Valid
    @NotNull
    private RelativeTimeInterval relativeTimeInterval;
    /**
     * Sales_ Tariff_ Entry. E_ Price_ Level. Unsigned_ Integer
     * urn:x-oca:ocpp:uid:1:569281
     * Defines the price level of this SalesTariffEntry (referring to NumEPriceLevels). Small values for the EPriceLevel represent a cheaper TariffEntry. Large values for the EPriceLevel represent a more expensive TariffEntry.
     * 
     * 
     */
    @JsonProperty("ePriceLevel")
    @JsonPropertyDescription("Sales_ Tariff_ Entry. E_ Price_ Level. Unsigned_ Integer\r\nurn:x-oca:ocpp:uid:1:569281\r\nDefines the price level of this SalesTariffEntry (referring to NumEPriceLevels). Small values for the EPriceLevel represent a cheaper TariffEntry. Large values for the EPriceLevel represent a more expensive TariffEntry.\r\n")
    @DecimalMin("0")
    private Integer ePriceLevel;
    @JsonProperty("consumptionCost")
    @Singular("consumptionCost")
    @Size(min = 1, max = 3)
    @Valid
    private List<ConsumptionCost> consumptionCost;

}
