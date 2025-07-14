
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
 * Charging_ Profile
 * urn:x-oca:ocpp:uid:2:233255
 * A ChargingProfile consists of ChargingSchedule, describing the amount of power or current that can be delivered per time interval.
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
    "id",
    "stackLevel",
    "chargingProfilePurpose",
    "chargingProfileKind",
    "recurrencyKind",
    "validFrom",
    "validTo",
    "chargingSchedule",
    "transactionId"
})
@Generated("jsonschema2pojo")
public class ChargingProfile {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Identified_ Object. MRID. Numeric_ Identifier
     * urn:x-enexis:ecdm:uid:1:569198
     * Id of ChargingProfile.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Identified_ Object. MRID. Numeric_ Identifier\r\nurn:x-enexis:ecdm:uid:1:569198\r\nId of ChargingProfile.\r\n")
    @NotNull
    private Integer id;
    /**
     * Charging_ Profile. Stack_ Level. Counter
     * urn:x-oca:ocpp:uid:1:569230
     * Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("stackLevel")
    @JsonPropertyDescription("Charging_ Profile. Stack_ Level. Counter\r\nurn:x-oca:ocpp:uid:1:569230\r\nValue determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.\r\n")
    @NotNull
    private Integer stackLevel;
    /**
     * Charging_ Profile. Charging_ Profile_ Purpose. Charging_ Profile_ Purpose_ Code
     * urn:x-oca:ocpp:uid:1:569231
     * Defines the purpose of the schedule transferred by this profile
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    @JsonPropertyDescription("Charging_ Profile. Charging_ Profile_ Purpose. Charging_ Profile_ Purpose_ Code\r\nurn:x-oca:ocpp:uid:1:569231\r\nDefines the purpose of the schedule transferred by this profile\r\n")
    @NotNull
    private ChargingProfilePurposeEnum chargingProfilePurpose;
    /**
     * Charging_ Profile. Charging_ Profile_ Kind. Charging_ Profile_ Kind_ Code
     * urn:x-oca:ocpp:uid:1:569232
     * Indicates the kind of schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileKind")
    @JsonPropertyDescription("Charging_ Profile. Charging_ Profile_ Kind. Charging_ Profile_ Kind_ Code\r\nurn:x-oca:ocpp:uid:1:569232\r\nIndicates the kind of schedule.\r\n")
    @NotNull
    private ChargingProfileKindEnum chargingProfileKind;
    /**
     * Charging_ Profile. Recurrency_ Kind. Recurrency_ Kind_ Code
     * urn:x-oca:ocpp:uid:1:569233
     * Indicates the start point of a recurrence.
     * 
     * 
     */
    @JsonProperty("recurrencyKind")
    @JsonPropertyDescription("Charging_ Profile. Recurrency_ Kind. Recurrency_ Kind_ Code\r\nurn:x-oca:ocpp:uid:1:569233\r\nIndicates the start point of a recurrence.\r\n")
    private RecurrencyKindEnum recurrencyKind;
    /**
     * Charging_ Profile. Valid_ From. Date_ Time
     * urn:x-oca:ocpp:uid:1:569234
     * Point in time at which the profile starts to be valid. If absent, the profile is valid as soon as it is received by the Charging Station.
     * 
     * 
     */
    @JsonProperty("validFrom")
    @JsonPropertyDescription("Charging_ Profile. Valid_ From. Date_ Time\r\nurn:x-oca:ocpp:uid:1:569234\r\nPoint in time at which the profile starts to be valid. If absent, the profile is valid as soon as it is received by the Charging Station.\r\n")
    private ZonedDateTime validFrom;
    /**
     * Charging_ Profile. Valid_ To. Date_ Time
     * urn:x-oca:ocpp:uid:1:569235
     * Point in time at which the profile stops to be valid. If absent, the profile is valid until it is replaced by another profile.
     * 
     * 
     */
    @JsonProperty("validTo")
    @JsonPropertyDescription("Charging_ Profile. Valid_ To. Date_ Time\r\nurn:x-oca:ocpp:uid:1:569235\r\nPoint in time at which the profile stops to be valid. If absent, the profile is valid until it is replaced by another profile.\r\n")
    private ZonedDateTime validTo;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    @Singular("chargingSchedule")
    @Size(min = 1, max = 3)
    @Valid
    @NotNull
    private List<ChargingSchedule> chargingSchedule;
    /**
     * SHALL only be included if ChargingProfilePurpose is set to TxProfile. The transactionId is used to match the profile to a specific transaction.
     * 
     * 
     */
    @JsonProperty("transactionId")
    @JsonPropertyDescription("SHALL only be included if ChargingProfilePurpose is set to TxProfile. The transactionId is used to match the profile to a specific transaction.\r\n")
    @Size(max = 36)
    private String transactionId;

}
