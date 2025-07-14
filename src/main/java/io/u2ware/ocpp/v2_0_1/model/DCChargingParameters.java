
package io.u2ware.ocpp.v2_0_1.model;

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
 * DC_ Charging_ Parameters
 * urn:x-oca:ocpp:uid:2:233251
 * EV DC charging parameters
 * 
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
    "customData",
    "evMaxCurrent",
    "evMaxVoltage",
    "energyAmount",
    "evMaxPower",
    "stateOfCharge",
    "evEnergyCapacity",
    "fullSoC",
    "bulkSoC"
})
@Generated("jsonschema2pojo")
public class DCChargingParameters {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * DC_ Charging_ Parameters. EV_ Max. Current
     * urn:x-oca:ocpp:uid:1:569215
     * Maximum current (amps) supported by the electric vehicle. Includes cable capacity.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    @JsonPropertyDescription("DC_ Charging_ Parameters. EV_ Max. Current\r\nurn:x-oca:ocpp:uid:1:569215\r\nMaximum current (amps) supported by the electric vehicle. Includes cable capacity.\r\n")
    @NotNull
    private Integer evMaxCurrent;
    /**
     * DC_ Charging_ Parameters. EV_ Max. Voltage
     * urn:x-oca:ocpp:uid:1:569216
     * Maximum voltage supported by the electric vehicle
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    @JsonPropertyDescription("DC_ Charging_ Parameters. EV_ Max. Voltage\r\nurn:x-oca:ocpp:uid:1:569216\r\nMaximum voltage supported by the electric vehicle\r\n")
    @NotNull
    private Integer evMaxVoltage;
    /**
     * DC_ Charging_ Parameters. Energy_ Amount. Energy_ Amount
     * urn:x-oca:ocpp:uid:1:569217
     * Amount of energy requested (in Wh). This inludes energy required for preconditioning.
     * 
     * 
     */
    @JsonProperty("energyAmount")
    @JsonPropertyDescription("DC_ Charging_ Parameters. Energy_ Amount. Energy_ Amount\r\nurn:x-oca:ocpp:uid:1:569217\r\nAmount of energy requested (in Wh). This inludes energy required for preconditioning.\r\n")
    private Integer energyAmount;
    /**
     * DC_ Charging_ Parameters. EV_ Max. Power
     * urn:x-oca:ocpp:uid:1:569218
     * Maximum power (in W) supported by the electric vehicle. Required for DC charging.
     * 
     * 
     */
    @JsonProperty("evMaxPower")
    @JsonPropertyDescription("DC_ Charging_ Parameters. EV_ Max. Power\r\nurn:x-oca:ocpp:uid:1:569218\r\nMaximum power (in W) supported by the electric vehicle. Required for DC charging.\r\n")
    private Integer evMaxPower;
    /**
     * DC_ Charging_ Parameters. State_ Of_ Charge. Numeric
     * urn:x-oca:ocpp:uid:1:569219
     * Energy available in the battery (in percent of the battery capacity)
     * 
     * 
     */
    @JsonProperty("stateOfCharge")
    @JsonPropertyDescription("DC_ Charging_ Parameters. State_ Of_ Charge. Numeric\r\nurn:x-oca:ocpp:uid:1:569219\r\nEnergy available in the battery (in percent of the battery capacity)\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private Integer stateOfCharge;
    /**
     * DC_ Charging_ Parameters. EV_ Energy_ Capacity. Numeric
     * urn:x-oca:ocpp:uid:1:569220
     * Capacity of the electric vehicle battery (in Wh)
     * 
     * 
     */
    @JsonProperty("evEnergyCapacity")
    @JsonPropertyDescription("DC_ Charging_ Parameters. EV_ Energy_ Capacity. Numeric\r\nurn:x-oca:ocpp:uid:1:569220\r\nCapacity of the electric vehicle battery (in Wh)\r\n")
    private Integer evEnergyCapacity;
    /**
     * DC_ Charging_ Parameters. Full_ SOC. Percentage
     * urn:x-oca:ocpp:uid:1:569221
     * Percentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100)
     * 
     * 
     */
    @JsonProperty("fullSoC")
    @JsonPropertyDescription("DC_ Charging_ Parameters. Full_ SOC. Percentage\r\nurn:x-oca:ocpp:uid:1:569221\r\nPercentage of SoC at which the EV considers the battery fully charged. (possible values: 0 - 100)\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private Integer fullSoC;
    /**
     * DC_ Charging_ Parameters. Bulk_ SOC. Percentage
     * urn:x-oca:ocpp:uid:1:569222
     * Percentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100)
     * 
     * 
     */
    @JsonProperty("bulkSoC")
    @JsonPropertyDescription("DC_ Charging_ Parameters. Bulk_ SOC. Percentage\r\nurn:x-oca:ocpp:uid:1:569222\r\nPercentage of SoC at which the EV considers a fast charging process to end. (possible values: 0 - 100)\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private Integer bulkSoC;

}
