
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
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


/**
 * A ChargingProfile consists of 1 to 3 ChargingSchedules with a list of ChargingSchedulePeriods, describing the amount of power or current that can be delivered per time interval.
 * 
 * image::images/ChargingProfile-Simple.png[]
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
    "id",
    "stackLevel",
    "chargingProfilePurpose",
    "chargingProfileKind",
    "recurrencyKind",
    "validFrom",
    "validTo",
    "transactionId",
    "maxOfflineDuration",
    "chargingSchedule",
    "invalidAfterOfflineDuration",
    "dynUpdateInterval",
    "dynUpdateTime",
    "priceScheduleSignature",
    "customData"
})
@Generated("jsonschema2pojo")
public class ChargingProfile {

    /**
     * Id of ChargingProfile. Unique within charging station. Id can have a negative value. This is useful to distinguish charging profiles from an external actor (external constraints) from charging profiles received from CSMS.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Id of ChargingProfile. Unique within charging station. Id can have a negative value. This is useful to distinguish charging profiles from an external actor (external constraints) from charging profiles received from CSMS.\r\n")
    @NotNull
    private Integer id;
    /**
     * Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("stackLevel")
    @JsonPropertyDescription("Value determining level in hierarchy stack of profiles. Higher values have precedence over lower values. Lowest level is 0.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer stackLevel;
    /**
     * Defines the purpose of the schedule transferred by this profile
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    @JsonPropertyDescription("Defines the purpose of the schedule transferred by this profile\r\n")
    @NotNull
    private ChargingProfilePurposeEnum chargingProfilePurpose;
    /**
     * Indicates the kind of schedule.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileKind")
    @JsonPropertyDescription("Indicates the kind of schedule.\r\n")
    @NotNull
    private ChargingProfileKindEnum chargingProfileKind;
    /**
     * Indicates the start point of a recurrence.
     * 
     * 
     */
    @JsonProperty("recurrencyKind")
    @JsonPropertyDescription("Indicates the start point of a recurrence.\r\n")
    private RecurrencyKindEnum recurrencyKind;
    /**
     * Point in time at which the profile starts to be valid. If absent, the profile is valid as soon as it is received by the Charging Station.
     * 
     * 
     */
    @JsonProperty("validFrom")
    @JsonPropertyDescription("Point in time at which the profile starts to be valid. If absent, the profile is valid as soon as it is received by the Charging Station.\r\n")
    private ZonedDateTime validFrom;
    /**
     * Point in time at which the profile stops to be valid. If absent, the profile is valid until it is replaced by another profile.
     * 
     * 
     */
    @JsonProperty("validTo")
    @JsonPropertyDescription("Point in time at which the profile stops to be valid. If absent, the profile is valid until it is replaced by another profile.\r\n")
    private ZonedDateTime validTo;
    /**
     * SHALL only be included if ChargingProfilePurpose is set to TxProfile in a SetChargingProfileRequest. The transactionId is used to match the profile to a specific transaction.
     * 
     * 
     */
    @JsonProperty("transactionId")
    @JsonPropertyDescription("SHALL only be included if ChargingProfilePurpose is set to TxProfile in a SetChargingProfileRequest. The transactionId is used to match the profile to a specific transaction.\r\n")
    @Size(max = 36)
    private String transactionId;
    /**
     * *(2.1)* Period in seconds that this charging profile remains valid after the Charging Station has gone offline. After this period the charging profile becomes invalid for as long as it is offline and the Charging Station reverts back to a valid profile with a lower stack level. 
     * If _invalidAfterOfflineDuration_ is true, then this charging profile will become permanently invalid.
     * A value of 0 means that the charging profile is immediately invalid while offline. When the field is absent, then  no timeout applies and the charging profile remains valid when offline.
     * 
     * 
     */
    @JsonProperty("maxOfflineDuration")
    @JsonPropertyDescription("*(2.1)* Period in seconds that this charging profile remains valid after the Charging Station has gone offline. After this period the charging profile becomes invalid for as long as it is offline and the Charging Station reverts back to a valid profile with a lower stack level. \r\nIf _invalidAfterOfflineDuration_ is true, then this charging profile will become permanently invalid.\r\nA value of 0 means that the charging profile is immediately invalid while offline. When the field is absent, then  no timeout applies and the charging profile remains valid when offline.\r\n")
    private Integer maxOfflineDuration;
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
     * *(2.1)* When set to true this charging profile will not be valid anymore after being offline for more than _maxOfflineDuration_. +
     *     When absent defaults to false.
     * 
     * 
     */
    @JsonProperty("invalidAfterOfflineDuration")
    @JsonPropertyDescription("*(2.1)* When set to true this charging profile will not be valid anymore after being offline for more than _maxOfflineDuration_. +\r\n    When absent defaults to false.\r\n")
    private Boolean invalidAfterOfflineDuration;
    /**
     * *(2.1)*  Interval in seconds after receipt of last update, when to request a profile update by sending a PullDynamicScheduleUpdateRequest message.
     *     A value of 0 or no value means that no update interval applies. +
     *     Only relevant in a dynamic charging profile.
     * 
     * 
     * 
     */
    @JsonProperty("dynUpdateInterval")
    @JsonPropertyDescription("*(2.1)*  Interval in seconds after receipt of last update, when to request a profile update by sending a PullDynamicScheduleUpdateRequest message.\r\n    A value of 0 or no value means that no update interval applies. +\r\n    Only relevant in a dynamic charging profile.\r\n\r\n")
    private Integer dynUpdateInterval;
    /**
     * *(2.1)* Time at which limits or setpoints in this charging profile were last updated by a PullDynamicScheduleUpdateRequest or UpdateDynamicScheduleRequest or by an external actor. +
     *     Only relevant in a dynamic charging profile.
     * 
     * 
     * 
     */
    @JsonProperty("dynUpdateTime")
    @JsonPropertyDescription("*(2.1)* Time at which limits or setpoints in this charging profile were last updated by a PullDynamicScheduleUpdateRequest or UpdateDynamicScheduleRequest or by an external actor. +\r\n    Only relevant in a dynamic charging profile.\r\n\r\n")
    private ZonedDateTime dynUpdateTime;
    /**
     * *(2.1)* ISO 15118-20 signature for all price schedules in _chargingSchedules_. +
     * Note: for 256-bit elliptic curves (like secp256k1) the ECDSA signature is 512 bits (64 bytes) and for 521-bit curves (like secp521r1) the signature is 1042 bits. This equals 131 bytes, which can be encoded as base64 in 176 bytes.
     * 
     * 
     */
    @JsonProperty("priceScheduleSignature")
    @JsonPropertyDescription("*(2.1)* ISO 15118-20 signature for all price schedules in _chargingSchedules_. +\r\nNote: for 256-bit elliptic curves (like secp256k1) the ECDSA signature is 512 bits (64 bytes) and for 521-bit curves (like secp521r1) the signature is 1042 bits. This equals 131 bytes, which can be encoded as base64 in 176 bytes.\r\n")
    @Size(max = 256)
    private String priceScheduleSignature;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
