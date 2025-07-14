
package io.u2ware.ocpp.v2_1.model;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * A ChargingProfileCriterionType is a filter for charging profiles to be selected by a GetChargingProfilesRequest.
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
    "chargingProfilePurpose",
    "stackLevel",
    "chargingProfileId",
    "chargingLimitSource",
    "customData"
})
@Generated("jsonschema2pojo")
public class ChargingProfileCriterion {

    /**
     * Defines the purpose of the schedule transferred by this profile
     * 
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    @JsonPropertyDescription("Defines the purpose of the schedule transferred by this profile\r\n")
    private ChargingProfilePurposeEnum chargingProfilePurpose;
    /**
     * Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.
     * 
     * 
     */
    @JsonProperty("stackLevel")
    @JsonPropertyDescription("Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.\r\n")
    @DecimalMin("0")
    private Integer stackLevel;
    /**
     * List of all the chargingProfileIds requested. Any ChargingProfile that matches one of these profiles will be reported. If omitted, the Charging Station SHALL not filter on chargingProfileId. This field SHALL NOT contain more ids than set in &lt;&lt;configkey-charging-profile-entries,ChargingProfileEntries.maxLimit&gt;&gt;
     * 
     * 
     * 
     */
    @JsonProperty("chargingProfileId")
    @JsonPropertyDescription("List of all the chargingProfileIds requested. Any ChargingProfile that matches one of these profiles will be reported. If omitted, the Charging Station SHALL not filter on chargingProfileId. This field SHALL NOT contain more ids than set in &lt;&lt;configkey-charging-profile-entries,ChargingProfileEntries.maxLimit&gt;&gt;\r\n\r\n")
    @Singular("chargingProfileId")
    @Size(min = 1)
    @Valid
    private List<Integer> chargingProfileId;
    /**
     * For which charging limit sources, charging profiles SHALL be reported. If omitted, the Charging Station SHALL not filter on chargingLimitSource. Values defined in Appendix as ChargingLimitSourceEnumStringType.
     * 
     * 
     */
    @JsonProperty("chargingLimitSource")
    @JsonPropertyDescription("For which charging limit sources, charging profiles SHALL be reported. If omitted, the Charging Station SHALL not filter on chargingLimitSource. Values defined in Appendix as ChargingLimitSourceEnumStringType.\r\n")
    @Singular("chargingLimitSource")
    @Size(min = 1, max = 4)
    @Valid
    private List<String> chargingLimitSource;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
