
package io.u2ware.ocpp.v2_1.model;

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
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * This contains the cost calculated during a transaction. It is used both for running cost and final cost of the transaction.
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
    "currency",
    "typeOfCost",
    "fixed",
    "energy",
    "chargingTime",
    "idleTime",
    "reservationTime",
    "reservationFixed",
    "total",
    "customData"
})
@Generated("jsonschema2pojo")
public class TotalCost {

    /**
     * Currency of the costs in ISO 4217 Code.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("currency")
    @JsonPropertyDescription("Currency of the costs in ISO 4217 Code.\r\n\r\n")
    @Size(max = 3)
    @NotNull
    private String currency;
    /**
     * Type of cost: normal or the minimum or maximum cost.
     * 
     * (Required)
     * 
     */
    @JsonProperty("typeOfCost")
    @JsonPropertyDescription("Type of cost: normal or the minimum or maximum cost.\r\n")
    @NotNull
    private TariffCostEnum typeOfCost;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("fixed")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price fixed;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("energy")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price energy;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("chargingTime")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price chargingTime;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("idleTime")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price idleTime;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("reservationTime")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price reservationTime;
    /**
     * Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.
     * 
     * 
     */
    @JsonProperty("reservationFixed")
    @JsonPropertyDescription("Price with and without tax. At least one of _exclTax_, _inclTax_ must be present.\r\n")
    @Valid
    private Price reservationFixed;
    /**
     * Total cost with and without tax. Contains the total of energy, charging time, idle time, fixed and reservation costs including and/or excluding tax.
     * 
     * (Required)
     * 
     */
    @JsonProperty("total")
    @JsonPropertyDescription("Total cost with and without tax. Contains the total of energy, charging time, idle time, fixed and reservation costs including and/or excluding tax.\r\n")
    @Valid
    @NotNull
    private TotalPrice total;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
