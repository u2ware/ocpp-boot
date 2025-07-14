
package io.u2ware.ocpp.v2_0_1.model;

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
 * AC_ Charging_ Parameters
 * urn:x-oca:ocpp:uid:2:233250
 * EV AC charging parameters.
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
    "energyAmount",
    "evMinCurrent",
    "evMaxCurrent",
    "evMaxVoltage"
})
@Generated("jsonschema2pojo")
public class ACChargingParameters {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * AC_ Charging_ Parameters. Energy_ Amount. Energy_ Amount
     * urn:x-oca:ocpp:uid:1:569211
     * Amount of energy requested (in Wh). This includes energy required for preconditioning.
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyAmount")
    @JsonPropertyDescription("AC_ Charging_ Parameters. Energy_ Amount. Energy_ Amount\r\nurn:x-oca:ocpp:uid:1:569211\r\nAmount of energy requested (in Wh). This includes energy required for preconditioning.\r\n")
    @NotNull
    private Integer energyAmount;
    /**
     * AC_ Charging_ Parameters. EV_ Min. Current
     * urn:x-oca:ocpp:uid:1:569212
     * Minimum current (amps) supported by the electric vehicle (per phase).
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMinCurrent")
    @JsonPropertyDescription("AC_ Charging_ Parameters. EV_ Min. Current\r\nurn:x-oca:ocpp:uid:1:569212\r\nMinimum current (amps) supported by the electric vehicle (per phase).\r\n")
    @NotNull
    private Integer evMinCurrent;
    /**
     * AC_ Charging_ Parameters. EV_ Max. Current
     * urn:x-oca:ocpp:uid:1:569213
     * Maximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxCurrent")
    @JsonPropertyDescription("AC_ Charging_ Parameters. EV_ Max. Current\r\nurn:x-oca:ocpp:uid:1:569213\r\nMaximum current (amps) supported by the electric vehicle (per phase). Includes cable capacity.\r\n")
    @NotNull
    private Integer evMaxCurrent;
    /**
     * AC_ Charging_ Parameters. EV_ Max. Voltage
     * urn:x-oca:ocpp:uid:1:569214
     * Maximum voltage supported by the electric vehicle
     * 
     * (Required)
     * 
     */
    @JsonProperty("evMaxVoltage")
    @JsonPropertyDescription("AC_ Charging_ Parameters. EV_ Max. Voltage\r\nurn:x-oca:ocpp:uid:1:569214\r\nMaximum voltage supported by the electric vehicle\r\n")
    @NotNull
    private Integer evMaxVoltage;

}
