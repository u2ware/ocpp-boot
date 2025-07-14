
package io.u2ware.ocpp.v2_1.model;

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
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Part of ISO 15118-20 price schedule.
 * 
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
    "taxRuleID",
    "taxRuleName",
    "taxIncludedInPrice",
    "appliesToEnergyFee",
    "appliesToParkingFee",
    "appliesToOverstayFee",
    "appliesToMinimumMaximumCost",
    "taxRate",
    "customData"
})
@Generated("jsonschema2pojo")
public class TaxRule {

    /**
     * Id for the tax rule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("taxRuleID")
    @JsonPropertyDescription("Id for the tax rule.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer taxRuleID;
    /**
     * Human readable string to identify the tax rule.
     * 
     * 
     */
    @JsonProperty("taxRuleName")
    @JsonPropertyDescription("Human readable string to identify the tax rule.\r\n")
    @Size(max = 100)
    private String taxRuleName;
    /**
     * Indicates whether the tax is included in any price or not.
     * 
     * 
     */
    @JsonProperty("taxIncludedInPrice")
    @JsonPropertyDescription("Indicates whether the tax is included in any price or not.\r\n")
    private Boolean taxIncludedInPrice;
    /**
     * Indicates whether this tax applies to Energy Fees.
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToEnergyFee")
    @JsonPropertyDescription("Indicates whether this tax applies to Energy Fees.\r\n")
    @NotNull
    private Boolean appliesToEnergyFee;
    /**
     * Indicates whether this tax applies to Parking Fees.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToParkingFee")
    @JsonPropertyDescription("Indicates whether this tax applies to Parking Fees.\r\n\r\n")
    @NotNull
    private Boolean appliesToParkingFee;
    /**
     * Indicates whether this tax applies to Overstay Fees.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToOverstayFee")
    @JsonPropertyDescription("Indicates whether this tax applies to Overstay Fees.\r\n\r\n")
    @NotNull
    private Boolean appliesToOverstayFee;
    /**
     * Indicates whether this tax applies to Minimum/Maximum Cost.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("appliesToMinimumMaximumCost")
    @JsonPropertyDescription("Indicates whether this tax applies to Minimum/Maximum Cost.\r\n\r\n")
    @NotNull
    private Boolean appliesToMinimumMaximumCost;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("taxRate")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    @NotNull
    private RationalNumber taxRate;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
