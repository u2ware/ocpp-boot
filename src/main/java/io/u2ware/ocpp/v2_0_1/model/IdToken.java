
package io.u2ware.ocpp.v2_0_1.model;

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
 * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
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
    "additionalInfo",
    "idToken",
    "type"
})
@Generated("jsonschema2pojo")
public class IdToken {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    @JsonProperty("additionalInfo")
    @Singular("additionalInfo")
    @Size(min = 1)
    @Valid
    private List<AdditionalInfo> additionalInfo;
    /**
     * IdToken is case insensitive. Might hold the hidden id of an RFID tag, but can for example also contain a UUID.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idToken")
    @JsonPropertyDescription("IdToken is case insensitive. Might hold the hidden id of an RFID tag, but can for example also contain a UUID.\r\n")
    @Size(max = 36)
    @NotNull
    private String idToken;
    /**
     * Enumeration of possible idToken types.
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Enumeration of possible idToken types.\r\n")
    @NotNull
    private IdTokenEnum type;

}
