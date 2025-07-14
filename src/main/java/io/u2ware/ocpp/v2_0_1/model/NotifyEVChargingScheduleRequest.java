
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "customData",
    "timeBase",
    "chargingSchedule",
    "evseId"
})
@Generated("jsonschema2pojo")
public class NotifyEVChargingScheduleRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Periods contained in the charging profile are relative to this point in time.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeBase")
    @JsonPropertyDescription("Periods contained in the charging profile are relative to this point in time.\r\n")
    @NotNull
    private ZonedDateTime timeBase;
    /**
     * Charging_ Schedule
     * urn:x-oca:ocpp:uid:2:233256
     * Charging schedule structure defines a list of charging periods, as used in: GetCompositeSchedule.conf and ChargingProfile. 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    @JsonPropertyDescription("Charging_ Schedule\r\nurn:x-oca:ocpp:uid:2:233256\r\nCharging schedule structure defines a list of charging periods, as used in: GetCompositeSchedule.conf and ChargingProfile. \r\n")
    @Valid
    @NotNull
    private ChargingSchedule chargingSchedule;
    /**
     * The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0.\r\n")
    @NotNull
    private Integer evseId;

}
