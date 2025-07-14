
package io.u2ware.ocpp.v2_1.model;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
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
    "chargingLimitSource",
    "chargingProfile",
    "tbc",
    "evseId",
    "customData"
})
@Generated("jsonschema2pojo")
public class ReportChargingProfilesRequest {

    /**
     * Id used to match the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt; message with the resulting ReportChargingProfilesRequest messages. When the CSMS provided a requestId in the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt;, this field SHALL contain the same value.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("Id used to match the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt; message with the resulting ReportChargingProfilesRequest messages. When the CSMS provided a requestId in the &lt;&lt;getchargingprofilesrequest, GetChargingProfilesRequest&gt;&gt;, this field SHALL contain the same value.\r\n")
    @NotNull
    private Integer requestId;
    /**
     * Source that has installed this charging profile. Values defined in Appendix as ChargingLimitSourceEnumStringType.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingLimitSource")
    @JsonPropertyDescription("Source that has installed this charging profile. Values defined in Appendix as ChargingLimitSourceEnumStringType.\r\n")
    @Size(max = 20)
    @NotNull
    private String chargingLimitSource;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfile")
    @Singular("chargingProfile")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<ChargingProfile> chargingProfile;
    /**
     * To Be Continued. Default value when omitted: false. false indicates that there are no further messages as part of this report.
     * 
     * 
     */
    @JsonProperty("tbc")
    @JsonPropertyDescription("To Be Continued. Default value when omitted: false. false indicates that there are no further messages as part of this report.\r\n")
    @lombok.Builder.Default
    private Boolean tbc = false;
    /**
     * The evse to which the charging profile applies. If evseId = 0, the message contains an overall limit for the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("The evse to which the charging profile applies. If evseId = 0, the message contains an overall limit for the Charging Station.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer evseId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
