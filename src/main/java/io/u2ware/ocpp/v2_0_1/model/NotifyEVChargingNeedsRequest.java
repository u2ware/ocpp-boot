
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "customData",
    "maxScheduleTuples",
    "chargingNeeds",
    "evseId"
})
@Generated("jsonschema2pojo")
public class NotifyEVChargingNeedsRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Contains the maximum schedule tuples the car supports per schedule.
     * 
     * 
     */
    @JsonProperty("maxScheduleTuples")
    @JsonPropertyDescription("Contains the maximum schedule tuples the car supports per schedule.\r\n")
    private Integer maxScheduleTuples;
    /**
     * Charging_ Needs
     * urn:x-oca:ocpp:uid:2:233249
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingNeeds")
    @JsonPropertyDescription("Charging_ Needs\r\nurn:x-oca:ocpp:uid:2:233249\r\n")
    @Valid
    @NotNull
    private ChargingNeeds chargingNeeds;
    /**
     * Defines the EVSE and connector to which the EV is connected. EvseId may not be 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("Defines the EVSE and connector to which the EV is connected. EvseId may not be 0.\r\n")
    @NotNull
    private Integer evseId;

}
