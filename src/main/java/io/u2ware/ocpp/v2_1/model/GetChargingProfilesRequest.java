
package io.u2ware.ocpp.v2_1.model;

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
    "requestId",
    "evseId",
    "chargingProfile",
    "customData"
})
@Generated("jsonschema2pojo")
public class GetChargingProfilesRequest {

    /**
     * Reference identification that is to be used by the Charging Station in the &lt;&lt;reportchargingprofilesrequest, ReportChargingProfilesRequest&gt;&gt; when provided.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("Reference identification that is to be used by the Charging Station in the &lt;&lt;reportchargingprofilesrequest, ReportChargingProfilesRequest&gt;&gt; when provided.\r\n")
    @NotNull
    private Integer requestId;
    /**
     * For which EVSE installed charging profiles SHALL be reported. If 0, only charging profiles installed on the Charging Station itself (the grid connection) SHALL be reported. If omitted, all installed charging profiles SHALL be reported. +
     * Reported charging profiles SHALL match the criteria in field _chargingProfile_.
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("For which EVSE installed charging profiles SHALL be reported. If 0, only charging profiles installed on the Charging Station itself (the grid connection) SHALL be reported. If omitted, all installed charging profiles SHALL be reported. +\r\nReported charging profiles SHALL match the criteria in field _chargingProfile_.\r\n")
    @DecimalMin("0")
    private Integer evseId;
    /**
     * A ChargingProfileCriterionType is a filter for charging profiles to be selected by a GetChargingProfilesRequest.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfile")
    @JsonPropertyDescription("A ChargingProfileCriterionType is a filter for charging profiles to be selected by a GetChargingProfilesRequest.\r\n\r\n")
    @Valid
    @NotNull
    private ChargingProfileCriterion chargingProfile;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
