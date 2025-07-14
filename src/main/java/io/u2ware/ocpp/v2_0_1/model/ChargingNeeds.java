
package io.u2ware.ocpp.v2_0_1.model;

import java.time.ZonedDateTime;
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
 * Charging_ Needs
 * urn:x-oca:ocpp:uid:2:233249
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
    "acChargingParameters",
    "dcChargingParameters",
    "requestedEnergyTransfer",
    "departureTime"
})
@Generated("jsonschema2pojo")
public class ChargingNeeds {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * AC_ Charging_ Parameters
     * urn:x-oca:ocpp:uid:2:233250
     * EV AC charging parameters.
     * 
     * 
     * 
     */
    @JsonProperty("acChargingParameters")
    @JsonPropertyDescription("AC_ Charging_ Parameters\r\nurn:x-oca:ocpp:uid:2:233250\r\nEV AC charging parameters.\r\n\r\n")
    @Valid
    private ACChargingParameters acChargingParameters;
    /**
     * DC_ Charging_ Parameters
     * urn:x-oca:ocpp:uid:2:233251
     * EV DC charging parameters
     * 
     * 
     * 
     * 
     */
    @JsonProperty("dcChargingParameters")
    @JsonPropertyDescription("DC_ Charging_ Parameters\r\nurn:x-oca:ocpp:uid:2:233251\r\nEV DC charging parameters\r\n\r\n\r\n")
    @Valid
    private DCChargingParameters dcChargingParameters;
    /**
     * Charging_ Needs. Requested. Energy_ Transfer_ Mode_ Code
     * urn:x-oca:ocpp:uid:1:569209
     * Mode of energy transfer requested by the EV.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedEnergyTransfer")
    @JsonPropertyDescription("Charging_ Needs. Requested. Energy_ Transfer_ Mode_ Code\r\nurn:x-oca:ocpp:uid:1:569209\r\nMode of energy transfer requested by the EV.\r\n")
    @NotNull
    private EnergyTransferModeEnum requestedEnergyTransfer;
    /**
     * Charging_ Needs. Departure_ Time. Date_ Time
     * urn:x-oca:ocpp:uid:1:569223
     * Estimated departure time of the EV.
     * 
     * 
     */
    @JsonProperty("departureTime")
    @JsonPropertyDescription("Charging_ Needs. Departure_ Time. Date_ Time\r\nurn:x-oca:ocpp:uid:1:569223\r\nEstimated departure time of the EV.\r\n")
    private ZonedDateTime departureTime;

}
