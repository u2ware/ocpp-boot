
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
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
 * The AbsolutePriceScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.
 * 
 * image::images/AbsolutePriceSchedule-Simple.png[]
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
    "timeAnchor",
    "priceScheduleID",
    "priceScheduleDescription",
    "currency",
    "language",
    "priceAlgorithm",
    "minimumCost",
    "maximumCost",
    "priceRuleStacks",
    "taxRules",
    "overstayRuleList",
    "additionalSelectedServices",
    "customData"
})
@Generated("jsonschema2pojo")
public class AbsolutePriceSchedule {

    /**
     * Starting point of price schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    @JsonPropertyDescription("Starting point of price schedule.\r\n")
    @NotNull
    private ZonedDateTime timeAnchor;
    /**
     * Unique ID of price schedule
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceScheduleID")
    @JsonPropertyDescription("Unique ID of price schedule\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer priceScheduleID;
    /**
     * Description of the price schedule.
     * 
     * 
     */
    @JsonProperty("priceScheduleDescription")
    @JsonPropertyDescription("Description of the price schedule.\r\n")
    @Size(max = 160)
    private String priceScheduleDescription;
    /**
     * Currency according to ISO 4217.
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    @JsonPropertyDescription("Currency according to ISO 4217.\r\n")
    @Size(max = 3)
    @NotNull
    private String currency;
    /**
     * String that indicates what language is used for the human readable strings in the price schedule. Based on ISO 639.
     * 
     * (Required)
     * 
     */
    @JsonProperty("language")
    @JsonPropertyDescription("String that indicates what language is used for the human readable strings in the price schedule. Based on ISO 639.\r\n")
    @Size(max = 8)
    @NotNull
    private String language;
    /**
     * A string in URN notation which shall uniquely identify an algorithm that defines how to compute an energy fee sum for a specific power profile based on the EnergyFee information from the PriceRule elements.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceAlgorithm")
    @JsonPropertyDescription("A string in URN notation which shall uniquely identify an algorithm that defines how to compute an energy fee sum for a specific power profile based on the EnergyFee information from the PriceRule elements.\r\n")
    @Size(max = 2000)
    @NotNull
    private String priceAlgorithm;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("minimumCost")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    private RationalNumber minimumCost;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("maximumCost")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    private RationalNumber maximumCost;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceRuleStacks")
    @Singular("priceRuleStacks")
    @Size(min = 1, max = 1024)
    @Valid
    @NotNull
    private List<PriceRuleStack> priceRuleStacks;
    @JsonProperty("taxRules")
    @Singular("taxRules")
    @Size(min = 1, max = 10)
    @Valid
    private List<TaxRule> taxRules;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("overstayRuleList")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    private OverstayRuleList overstayRuleList;
    @JsonProperty("additionalSelectedServices")
    @Singular("additionalSelectedServices")
    @Size(min = 1, max = 5)
    @Valid
    private List<AdditionalSelectedServices> additionalSelectedServices;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
