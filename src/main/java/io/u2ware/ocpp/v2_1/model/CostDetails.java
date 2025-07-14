
package io.u2ware.ocpp.v2_1.model;

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
 * CostDetailsType contains the cost as calculated by Charging Station based on provided TariffType.
 * 
 * NOTE: Reservation is not shown as a _chargingPeriod_, because it took place outside of the transaction.
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
    "chargingPeriods",
    "totalCost",
    "totalUsage",
    "failureToCalculate",
    "failureReason",
    "customData"
})
@Generated("jsonschema2pojo")
public class CostDetails {

    @JsonProperty("chargingPeriods")
    @Singular("chargingPeriods")
    @Size(min = 1)
    @Valid
    private List<ChargingPeriod> chargingPeriods;
    /**
     * This contains the cost calculated during a transaction. It is used both for running cost and final cost of the transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("totalCost")
    @JsonPropertyDescription("This contains the cost calculated during a transaction. It is used both for running cost and final cost of the transaction.\r\n")
    @Valid
    @NotNull
    private TotalCost totalCost;
    /**
     * This contains the calculated usage of energy, charging time and idle time during a transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("totalUsage")
    @JsonPropertyDescription("This contains the calculated usage of energy, charging time and idle time during a transaction.\r\n")
    @Valid
    @NotNull
    private TotalUsage totalUsage;
    /**
     * If set to true, then Charging Station has failed to calculate the cost.
     * 
     * 
     * 
     */
    @JsonProperty("failureToCalculate")
    @JsonPropertyDescription("If set to true, then Charging Station has failed to calculate the cost.\r\n\r\n")
    private Boolean failureToCalculate;
    /**
     * Optional human-readable reason text in case of failure to calculate.
     * 
     * 
     * 
     */
    @JsonProperty("failureReason")
    @JsonPropertyDescription("Optional human-readable reason text in case of failure to calculate.\r\n\r\n")
    @Size(max = 500)
    private String failureReason;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
