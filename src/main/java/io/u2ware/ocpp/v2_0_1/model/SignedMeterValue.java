
package io.u2ware.ocpp.v2_0_1.model;

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
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Represent a signed version of the meter value.
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
    "signedMeterData",
    "signingMethod",
    "encodingMethod",
    "publicKey"
})
@Generated("jsonschema2pojo")
public class SignedMeterValue {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Base64 encoded, contains the signed data which might contain more then just the meter value. It can contain information like timestamps, reference to a customer etc.
     * 
     * (Required)
     * 
     */
    @JsonProperty("signedMeterData")
    @JsonPropertyDescription("Base64 encoded, contains the signed data which might contain more then just the meter value. It can contain information like timestamps, reference to a customer etc.\r\n")
    @Size(max = 2500)
    @NotNull
    private String signedMeterData;
    /**
     * Method used to create the digital signature.
     * 
     * (Required)
     * 
     */
    @JsonProperty("signingMethod")
    @JsonPropertyDescription("Method used to create the digital signature.\r\n")
    @Size(max = 50)
    @NotNull
    private String signingMethod;
    /**
     * Method used to encode the meter values before applying the digital signature algorithm.
     * 
     * (Required)
     * 
     */
    @JsonProperty("encodingMethod")
    @JsonPropertyDescription("Method used to encode the meter values before applying the digital signature algorithm.\r\n")
    @Size(max = 50)
    @NotNull
    private String encodingMethod;
    /**
     * Base64 encoded, sending depends on configuration variable _PublicKeyWithSignedMeterValue_.
     * 
     * (Required)
     * 
     */
    @JsonProperty("publicKey")
    @JsonPropertyDescription("Base64 encoded, sending depends on configuration variable _PublicKeyWithSignedMeterValue_.\r\n")
    @Size(max = 2500)
    @NotNull
    private String publicKey;

}
