
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
 * The PriceLevelScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.
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
    "priceLevelScheduleEntries",
    "timeAnchor",
    "priceScheduleId",
    "priceScheduleDescription",
    "numberOfPriceLevels",
    "customData"
})
@Generated("jsonschema2pojo")
public class PriceLevelSchedule {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceLevelScheduleEntries")
    @Singular("priceLevelScheduleEntries")
    @Size(min = 1, max = 100)
    @Valid
    @NotNull
    private List<PriceLevelScheduleEntry> priceLevelScheduleEntries;
    /**
     * Starting point of this price schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    @JsonPropertyDescription("Starting point of this price schedule.\r\n")
    @NotNull
    private ZonedDateTime timeAnchor;
    /**
     * Unique ID of this price schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceScheduleId")
    @JsonPropertyDescription("Unique ID of this price schedule.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer priceScheduleId;
    /**
     * Description of the price schedule.
     * 
     * 
     */
    @JsonProperty("priceScheduleDescription")
    @JsonPropertyDescription("Description of the price schedule.\r\n")
    @Size(max = 32)
    private String priceScheduleDescription;
    /**
     * Defines the overall number of distinct price level elements used across all PriceLevelSchedules.
     * 
     * (Required)
     * 
     */
    @JsonProperty("numberOfPriceLevels")
    @JsonPropertyDescription("Defines the overall number of distinct price level elements used across all PriceLevelSchedules.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer numberOfPriceLevels;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
