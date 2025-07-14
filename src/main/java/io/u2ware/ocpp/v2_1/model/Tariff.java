
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
 * A tariff is described by fields with prices for:
 * energy,
 * charging time,
 * idle time,
 * fixed fee,
 * reservation time,
 * reservation fixed fee. +
 * Each of these fields may have (optional) conditions that specify when a price is applicable. +
 * The _description_ contains a human-readable explanation of the tariff to be shown to the user. +
 * The other fields are parameters that define the tariff. These are used by the charging station to calculate the price.
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
    "tariffId",
    "description",
    "currency",
    "energy",
    "validFrom",
    "chargingTime",
    "idleTime",
    "fixedFee",
    "reservationTime",
    "reservationFixed",
    "minCost",
    "maxCost",
    "customData"
})
@Generated("jsonschema2pojo")
public class Tariff {

    /**
     * Unique id of tariff
     * 
     * (Required)
     * 
     */
    @JsonProperty("tariffId")
    @JsonPropertyDescription("Unique id of tariff\r\n")
    @Size(max = 60)
    @NotNull
    private String tariffId;
    @JsonProperty("description")
    @Singular("description")
    @Size(min = 1, max = 10)
    @Valid
    private List<MessageContent> description;
    /**
     * Currency code according to ISO 4217
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    @JsonPropertyDescription("Currency code according to ISO 4217\r\n")
    @Size(max = 3)
    @NotNull
    private String currency;
    /**
     * Price elements and tax for energy
     * 
     * 
     */
    @JsonProperty("energy")
    @JsonPropertyDescription("Price elements and tax for energy\r\n")
    @Valid
    private TariffEnergy energy;
    /**
     * Time when this tariff becomes active. When absent, it is immediately active.
     * 
     * 
     */
    @JsonProperty("validFrom")
    @JsonPropertyDescription("Time when this tariff becomes active. When absent, it is immediately active.\r\n")
    private ZonedDateTime validFrom;
    /**
     * Price elements and tax for time
     * 
     * 
     * 
     */
    @JsonProperty("chargingTime")
    @JsonPropertyDescription("Price elements and tax for time\r\n\r\n")
    @Valid
    private TariffTime chargingTime;
    /**
     * Price elements and tax for time
     * 
     * 
     * 
     */
    @JsonProperty("idleTime")
    @JsonPropertyDescription("Price elements and tax for time\r\n\r\n")
    @Valid
    private TariffTime idleTime;
    @JsonProperty("fixedFee")
    @Valid
    private TariffFixed fixedFee;
    /**
     * Price elements and tax for time
     * 
     * 
     * 
     */
    @JsonProperty("reservationTime")
    @JsonPropertyDescription("Price elements and tax for time\r\n\r\n")
    @Valid
    private TariffTime reservationTime;
    @JsonProperty("reservationFixed")
    @Valid
    private TariffFixed reservationFixed;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("minCost")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price minCost;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("maxCost")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price maxCost;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
