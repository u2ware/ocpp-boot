
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
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
 * *(2.1)* Price schedule of EV energy offer.
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
    "currency",
    "evAbsolutePriceScheduleEntries",
    "priceAlgorithm",
    "customData"
})
@Generated("jsonschema2pojo")
public class EVAbsolutePriceSchedule {

    /**
     * Starting point in time of the EVEnergyOffer.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    @JsonPropertyDescription("Starting point in time of the EVEnergyOffer.\r\n")
    @NotNull
    private ZonedDateTime timeAnchor;
    /**
     * Currency code according to ISO 4217.
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    @JsonPropertyDescription("Currency code according to ISO 4217.\r\n")
    @Size(max = 3)
    @NotNull
    private String currency;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("evAbsolutePriceScheduleEntries")
    @Singular("evAbsolutePriceScheduleEntries")
    @Size(min = 1, max = 1024)
    @Valid
    @NotNull
    private List<EVAbsolutePriceScheduleEntry> evAbsolutePriceScheduleEntries;
    /**
     * ISO 15118-20 URN of price algorithm: Power, PeakPower, StackedEnergy.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceAlgorithm")
    @JsonPropertyDescription("ISO 15118-20 URN of price algorithm: Power, PeakPower, StackedEnergy.\r\n")
    @Size(max = 2000)
    @NotNull
    private String priceAlgorithm;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
