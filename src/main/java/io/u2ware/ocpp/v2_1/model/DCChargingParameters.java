
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * EV DC charging parameters for ISO 15118-2
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
    "evMaxCurrent",
    "evMaxVoltage",
    "evMaxPower",
    "evEnergyCapacity",
    "energyAmount",
    "stateOfCharge",
    "fullSoC",
    "bulkSoC",
    "customData"
})
@Generated("jsonschema2pojo")
public class DCChargingParameters {

    /**
     * Maximum current (in A) supported by the electric vehicle. Includes cable capacity.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType:EVMaximumCurrentLimit
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    @JsonPropertyDescription("Maximum current (in A) supported by the electric vehicle. Includes cable capacity.\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType:EVMaximumCurrentLimit\r\n")
    @NotNull
    private Double evMaxCurrent;
    /**
     * Maximum voltage supported by the electric vehicle.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVMaximumVoltageLimit
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    @JsonPropertyDescription("Maximum voltage supported by the electric vehicle.\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: EVMaximumVoltageLimit\r\n\r\n")
    @NotNull
    private Double evMaxVoltage;
    /**
     * Maximum power (in W) supported by the electric vehicle. Required for DC charging.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVMaximumPowerLimit
     * 
     * 
     * 
     */
    @JsonProperty("evMaxPower")
    @JsonPropertyDescription("Maximum power (in W) supported by the electric vehicle. Required for DC charging.\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: EVMaximumPowerLimit\r\n\r\n")
    private Double evMaxPower;
    /**
     * Capacity of the electric vehicle battery (in Wh).
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVEnergyCapacity
     * 
     * 
     * 
     */
    @JsonProperty("evEnergyCapacity")
    @JsonPropertyDescription("Capacity of the electric vehicle battery (in Wh).\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: EVEnergyCapacity\r\n\r\n")
    private Double evEnergyCapacity;
    /**
     * Amount of energy requested (in Wh). This inludes energy required for preconditioning.
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: EVEnergyRequest
     * 
     * 
     * 
     * 
     */
    @JsonProperty("energyAmount")
    @JsonPropertyDescription("Amount of energy requested (in Wh). This inludes energy required for preconditioning.\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: EVEnergyRequest\r\n\r\n\r\n")
    private Double energyAmount;
    /**
     * Energy available in the battery (in percent of the battery capacity)
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: DC_EVStatus: EVRESSSOC
     * 
     * 
     * 
     */
    @JsonProperty("stateOfCharge")
    @JsonPropertyDescription("Energy available in the battery (in percent of the battery capacity)\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: DC_EVStatus: EVRESSSOC\r\n\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private Integer stateOfCharge;
    /**
     * Percentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100)
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: FullSOC
     * 
     * 
     * 
     */
    @JsonProperty("fullSoC")
    @JsonPropertyDescription("Percentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100)\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: FullSOC\r\n\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private Integer fullSoC;
    /**
     * Percentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100)
     * Relates to: +
     * *ISO 15118-2*: DC_EVChargeParameterType: BulkSOC
     * 
     * 
     * 
     */
    @JsonProperty("bulkSoC")
    @JsonPropertyDescription("Percentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100)\r\nRelates to: +\r\n*ISO 15118-2*: DC_EVChargeParameterType: BulkSOC\r\n\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private Integer bulkSoC;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
