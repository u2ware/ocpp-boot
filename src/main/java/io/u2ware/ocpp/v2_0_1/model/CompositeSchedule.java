
package io.u2ware.ocpp.v2_0_1.model;

import java.time.ZonedDateTime;
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
 * Composite_ Schedule
 * urn:x-oca:ocpp:uid:2:233362
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
    "chargingSchedulePeriod",
    "evseId",
    "duration",
    "scheduleStart",
    "chargingRateUnit"
})
@Generated("jsonschema2pojo")
public class CompositeSchedule {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    @Singular("chargingSchedulePeriod")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<ChargingSchedulePeriod> chargingSchedulePeriod;
    /**
     * The ID of the EVSE for which the
     * schedule is requested. When evseid=0, the
     * Charging Station calculated the expected
     * consumption for the grid connection.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("The ID of the EVSE for which the\r\nschedule is requested. When evseid=0, the\r\nCharging Station calculated the expected\r\nconsumption for the grid connection.\r\n")
    @NotNull
    private Integer evseId;
    /**
     * Duration of the schedule in seconds.
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Duration of the schedule in seconds.\r\n")
    @NotNull
    private Integer duration;
    /**
     * Composite_ Schedule. Start. Date_ Time
     * urn:x-oca:ocpp:uid:1:569456
     * Date and time at which the schedule becomes active. All time measurements within the schedule are relative to this timestamp.
     * 
     * (Required)
     * 
     */
    @JsonProperty("scheduleStart")
    @JsonPropertyDescription("Composite_ Schedule. Start. Date_ Time\r\nurn:x-oca:ocpp:uid:1:569456\r\nDate and time at which the schedule becomes active. All time measurements within the schedule are relative to this timestamp.\r\n")
    @NotNull
    private ZonedDateTime scheduleStart;
    /**
     * The unit of measure Limit is
     * expressed in.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    @JsonPropertyDescription("The unit of measure Limit is\r\nexpressed in.\r\n")
    @NotNull
    private ChargingRateUnitEnum chargingRateUnit;

}
