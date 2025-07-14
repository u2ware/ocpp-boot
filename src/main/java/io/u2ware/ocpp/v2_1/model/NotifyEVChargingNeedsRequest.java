
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
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
    "evseId",
    "maxScheduleTuples",
    "chargingNeeds",
    "timestamp",
    "customData"
})
@Generated("jsonschema2pojo")
public class NotifyEVChargingNeedsRequest {

    /**
     * Defines the EVSE and connector to which the EV is connected. EvseId may not be 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("Defines the EVSE and connector to which the EV is connected. EvseId may not be 0.\r\n")
    @DecimalMin("1")
    @NotNull
    private Integer evseId;
    /**
     * Contains the maximum elements the EV supports for: +
     * - ISO 15118-2: schedule tuples in SASchedule (both Pmax and Tariff). +
     * - ISO 15118-20: PowerScheduleEntry, PriceRule and PriceLevelScheduleEntries.
     * 
     * 
     */
    @JsonProperty("maxScheduleTuples")
    @JsonPropertyDescription("Contains the maximum elements the EV supports for: +\r\n- ISO 15118-2: schedule tuples in SASchedule (both Pmax and Tariff). +\r\n- ISO 15118-20: PowerScheduleEntry, PriceRule and PriceLevelScheduleEntries.\r\n")
    @DecimalMin("0")
    private Integer maxScheduleTuples;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingNeeds")
    @Valid
    @NotNull
    private ChargingNeeds chargingNeeds;
    /**
     * *(2.1)* Time when EV charging needs were received. +
     * Field can be added when charging station was offline when charging needs were received.
     * 
     * 
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("*(2.1)* Time when EV charging needs were received. +\r\nField can be added when charging station was offline when charging needs were received.\r\n\r\n")
    private ZonedDateTime timestamp;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
