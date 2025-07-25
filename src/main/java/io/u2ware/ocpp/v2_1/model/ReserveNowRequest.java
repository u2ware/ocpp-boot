
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
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
    "id",
    "expiryDateTime",
    "connectorType",
    "idToken",
    "evseId",
    "groupIdToken",
    "customData"
})
@Generated("jsonschema2pojo")
public class ReserveNowRequest {

    /**
     * Id of reservation.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Id of reservation.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer id;
    /**
     * Date and time at which the reservation expires.
     * 
     * (Required)
     * 
     */
    @JsonProperty("expiryDateTime")
    @JsonPropertyDescription("Date and time at which the reservation expires.\r\n")
    @NotNull
    private ZonedDateTime expiryDateTime;
    /**
     * This field specifies the connector type. Values defined in Appendix as ConnectorEnumStringType.
     * 
     * 
     */
    @JsonProperty("connectorType")
    @JsonPropertyDescription("This field specifies the connector type. Values defined in Appendix as ConnectorEnumStringType.\r\n")
    @Size(max = 20)
    private String connectorType;
    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idToken")
    @JsonPropertyDescription("Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.\r\n")
    @Valid
    @NotNull
    private IdToken idToken;
    /**
     * This contains ID of the evse to be reserved.
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("This contains ID of the evse to be reserved.\r\n")
    @DecimalMin("0")
    private Integer evseId;
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
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
