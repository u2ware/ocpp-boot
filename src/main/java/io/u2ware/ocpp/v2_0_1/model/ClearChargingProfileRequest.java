
package io.u2ware.ocpp.v2_0_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
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
    "chargingProfileId",
    "chargingProfileCriteria"
})
@Generated("jsonschema2pojo")
public class ClearChargingProfileRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * The Id of the charging profile to clear.
     * 
     * 
     */
    @JsonProperty("chargingProfileId")
    @JsonPropertyDescription("The Id of the charging profile to clear.\r\n")
    private Integer chargingProfileId;
    /**
     * Charging_ Profile
     * urn:x-oca:ocpp:uid:2:233255
     * A ChargingProfile consists of a ChargingSchedule, describing the amount of power or current that can be delivered per time interval.
     * 
     * 
     */
    @JsonProperty("chargingProfileCriteria")
    @JsonPropertyDescription("Charging_ Profile\r\nurn:x-oca:ocpp:uid:2:233255\r\nA ChargingProfile consists of a ChargingSchedule, describing the amount of power or current that can be delivered per time interval.\r\n")
    @Valid
    private ClearChargingProfile chargingProfileCriteria;

}
