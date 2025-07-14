
package io.u2ware.ocpp.v2_1.model;

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
 * A SalesTariff provided by a Mobility Operator (EMSP) .
 * NOTE: This dataType is based on dataTypes from &lt;&lt;ref-ISOIEC15118-2,ISO 15118-2&gt;&gt;.
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
    "id",
    "salesTariffDescription",
    "numEPriceLevels",
    "salesTariffEntry",
    "customData"
})
@Generated("jsonschema2pojo")
public class SalesTariff {

    /**
     * SalesTariff identifier used to identify one sales tariff. An SAID remains a unique identifier for one schedule throughout a charging session.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("SalesTariff identifier used to identify one sales tariff. An SAID remains a unique identifier for one schedule throughout a charging session.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer id;
    /**
     * A human readable title/short description of the sales tariff e.g. for HMI display purposes.
     * 
     * 
     */
    @JsonProperty("salesTariffDescription")
    @JsonPropertyDescription("A human readable title/short description of the sales tariff e.g. for HMI display purposes.\r\n")
    @Size(max = 32)
    private String salesTariffDescription;
    /**
     * Defines the overall number of distinct price levels used across all provided SalesTariff elements.
     * 
     * 
     */
    @JsonProperty("numEPriceLevels")
    @JsonPropertyDescription("Defines the overall number of distinct price levels used across all provided SalesTariff elements.\r\n")
    @DecimalMin("0")
    private Integer numEPriceLevels;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("salesTariffEntry")
    @Singular("salesTariffEntry")
    @Size(min = 1, max = 1024)
    @Valid
    @NotNull
    private List<SalesTariffEntry> salesTariffEntry;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
