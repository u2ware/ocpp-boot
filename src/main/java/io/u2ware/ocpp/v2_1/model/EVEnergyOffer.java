
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
 * *(2.1)* A schedule of the energy amount over time that EV is willing to discharge. A negative value indicates the willingness to discharge under specific conditions, a positive value indicates that the EV currently is not able to offer energy to discharge. 
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
    "evAbsolutePriceSchedule",
    "evPowerSchedule",
    "customData"
})
@Generated("jsonschema2pojo")
public class EVEnergyOffer {

    /**
     * *(2.1)* Price schedule of EV energy offer.
     * 
     * 
     */
    @JsonProperty("evAbsolutePriceSchedule")
    @JsonPropertyDescription("*(2.1)* Price schedule of EV energy offer.\r\n")
    @Valid
    private EVAbsolutePriceSchedule evAbsolutePriceSchedule;
    /**
     * *(2.1)* Schedule of EV energy offer.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evPowerSchedule")
    @JsonPropertyDescription("*(2.1)* Schedule of EV energy offer.\r\n")
    @Valid
    @NotNull
    private EVPowerSchedule evPowerSchedule;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
