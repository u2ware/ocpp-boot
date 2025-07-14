
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * EV AC charging parameters for ISO 15118-2
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
    "energyAmount",
    "evMinCurrent",
    "evMaxCurrent",
    "evMaxVoltage",
    "customData"
})
@Generated("jsonschema2pojo")
public class ACChargingParameters {

    /**
     * Amount of energy requested (in Wh). This includes energy required for preconditioning.
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EAmount +
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyAmount")
    @JsonPropertyDescription("Amount of energy requested (in Wh). This includes energy required for preconditioning.\r\nRelates to: +\r\n*ISO 15118-2*: AC_EVChargeParameterType: EAmount +\r\n*ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest\r\n\r\n")
    @NotNull
    private Double energyAmount;
    /**
     * Minimum current (amps) supported by the electric vehicle (per phase).
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EVMinCurrent
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMinCurrent")
    @JsonPropertyDescription("Minimum current (amps) supported by the electric vehicle (per phase).\r\nRelates to: +\r\n*ISO 15118-2*: AC_EVChargeParameterType: EVMinCurrent\r\n\r\n")
    @NotNull
    private Double evMinCurrent;
    /**
     * Maximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity.
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EVMaxCurrent
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    @JsonPropertyDescription("Maximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity.\r\nRelates to: +\r\n*ISO 15118-2*: AC_EVChargeParameterType: EVMaxCurrent\r\n\r\n")
    @NotNull
    private Double evMaxCurrent;
    /**
     * Maximum voltage supported by the electric vehicle.
     * Relates to: +
     * *ISO 15118-2*: AC_EVChargeParameterType: EVMaxVoltage
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    @JsonPropertyDescription("Maximum voltage supported by the electric vehicle.\r\nRelates to: +\r\n*ISO 15118-2*: AC_EVChargeParameterType: EVMaxVoltage\r\n\r\n")
    @NotNull
    private Double evMaxVoltage;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
