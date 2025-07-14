
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * A ClearChargingProfileType is a filter for charging profiles to be cleared by ClearChargingProfileRequest.
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
    "evseId",
    "chargingProfilePurpose",
    "stackLevel",
    "customData"
})
@Generated("jsonschema2pojo")
public class ClearChargingProfile {

    /**
     * Specifies the id of the EVSE for which to clear charging profiles. An evseId of zero (0) specifies the charging profile for the overall Charging Station. Absence of this parameter means the clearing applies to all charging profiles that match the other criteria in the request.
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("Specifies the id of the EVSE for which to clear charging profiles. An evseId of zero (0) specifies the charging profile for the overall Charging Station. Absence of this parameter means the clearing applies to all charging profiles that match the other criteria in the request.\r\n\r\n")
    @DecimalMin("0")
    private Integer evseId;
    /**
     * Specifies to purpose of the charging profiles that will be cleared, if they meet the other criteria in the request.
     * 
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    @JsonPropertyDescription("Specifies to purpose of the charging profiles that will be cleared, if they meet the other criteria in the request.\r\n")
    private ChargingProfilePurposeEnum chargingProfilePurpose;
    /**
     * Specifies the stackLevel for which charging profiles will be cleared, if they meet the other criteria in the request.
     * 
     * 
     */
    @JsonProperty("stackLevel")
    @JsonPropertyDescription("Specifies the stackLevel for which charging profiles will be cleared, if they meet the other criteria in the request.\r\n")
    @DecimalMin("0")
    private Integer stackLevel;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
