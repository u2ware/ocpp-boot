
package io.u2ware.ocpp.v2_1.model;

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
 * Contains status information about an identifier.
 * It is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.
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
    "status",
    "cacheExpiryDateTime",
    "chargingPriority",
    "groupIdToken",
    "language1",
    "language2",
    "evseId",
    "personalMessage",
    "customData"
})
@Generated("jsonschema2pojo")
public class IdTokenInfo {

    /**
     * Current status of the ID Token.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Current status of the ID Token.\r\n")
    @NotNull
    private AuthorizationStatusEnum status;
    /**
     * Date and Time after which the token must be considered invalid.
     * 
     * 
     */
    @JsonProperty("cacheExpiryDateTime")
    @JsonPropertyDescription("Date and Time after which the token must be considered invalid.\r\n")
    private ZonedDateTime cacheExpiryDateTime;
    /**
     * Priority from a business point of view. Default priority is 0, The range is from -9 to 9. Higher values indicate a higher priority. The chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; overrules this one. 
     * 
     * 
     */
    @JsonProperty("chargingPriority")
    @JsonPropertyDescription("Priority from a business point of view. Default priority is 0, The range is from -9 to 9. Higher values indicate a higher priority. The chargingPriority in &lt;&lt;transactioneventresponse,TransactionEventResponse&gt;&gt; overrules this one. \r\n")
    private Integer chargingPriority;
    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * 
     */
    @JsonProperty("groupIdToken")
    @JsonPropertyDescription("Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.\r\n")
    @Valid
    private IdToken groupIdToken;
    /**
     * Preferred user interface language of identifier user. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;.
     * 
     * 
     * 
     */
    @JsonProperty("language1")
    @JsonPropertyDescription("Preferred user interface language of identifier user. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;.\r\n\r\n")
    @Size(max = 8)
    private String language1;
    /**
     * Second preferred user interface language of identifier user. Don’t use when language1 is omitted, has to be different from language1. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;.
     * 
     * 
     */
    @JsonProperty("language2")
    @JsonPropertyDescription("Second preferred user interface language of identifier user. Don\u2019t use when language1 is omitted, has to be different from language1. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;.\r\n")
    @Size(max = 8)
    private String language2;
    /**
     * Only used when the IdToken is only valid for one or more specific EVSEs, not for the entire Charging Station.
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("Only used when the IdToken is only valid for one or more specific EVSEs, not for the entire Charging Station.\r\n\r\n")
    @Singular("evseId")
    @Size(min = 1)
    @Valid
    private List<Integer> evseId;
    /**
     * Contains message details, for a message to be displayed on a Charging Station.
     * 
     * 
     * 
     */
    @JsonProperty("personalMessage")
    @JsonPropertyDescription("Contains message details, for a message to be displayed on a Charging Station.\r\n\r\n")
    @Valid
    private MessageContent personalMessage;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
