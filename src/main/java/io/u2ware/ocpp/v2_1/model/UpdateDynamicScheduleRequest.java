
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
 * Id of dynamic charging profile to update.
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
    "chargingProfileId",
    "scheduleUpdate",
    "customData"
})
@Generated("jsonschema2pojo")
public class UpdateDynamicScheduleRequest {

    /**
     * Id of charging profile to update.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileId")
    @JsonPropertyDescription("Id of charging profile to update.\r\n")
    @NotNull
    private Integer chargingProfileId;
    /**
     * Updates to a ChargingSchedulePeriodType for dynamic charging profiles.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("scheduleUpdate")
    @JsonPropertyDescription("Updates to a ChargingSchedulePeriodType for dynamic charging profiles.\r\n\r\n")
    @Valid
    @NotNull
    private ChargingScheduleUpdate scheduleUpdate;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
