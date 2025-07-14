
package io.u2ware.ocpp.v2_1.model;

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
    "signedMeterData",
    "signingMethod",
    "encodingMethod",
    "publicKey",
    "customData"
})
@Generated("jsonschema2pojo")
public class SignedMeterValue {

    /**
     * Base64 encoded, contains the signed data from the meter in the format specified in _encodingMethod_, which might contain more then just the meter value. It can contain information like timestamps, reference to a customer etc.
     * 
     * (Required)
     * 
     */
    @JsonProperty("signedMeterData")
    @JsonPropertyDescription("Base64 encoded, contains the signed data from the meter in the format specified in _encodingMethod_, which might contain more then just the meter value. It can contain information like timestamps, reference to a customer etc.\r\n")
    @Size(max = 32768)
    @NotNull
    private String signedMeterData;
    /**
     * *(2.1)* Method used to create the digital signature. Optional, if already included in _signedMeterData_. Standard values for this are defined in Appendix as SigningMethodEnumStringType.
     * 
     * 
     */
    @JsonProperty("signingMethod")
    @JsonPropertyDescription("*(2.1)* Method used to create the digital signature. Optional, if already included in _signedMeterData_. Standard values for this are defined in Appendix as SigningMethodEnumStringType.\r\n")
    @Size(max = 50)
    private String signingMethod;
    /**
     * Format used by the energy meter to encode the meter data. For example: OCMF or EDL.
     * 
     * (Required)
     * 
     */
    @JsonProperty("encodingMethod")
    @JsonPropertyDescription("Format used by the energy meter to encode the meter data. For example: OCMF or EDL.\r\n")
    @Size(max = 50)
    @NotNull
    private String encodingMethod;
    /**
     * *(2.1)* Base64 encoded, sending depends on configuration variable _PublicKeyWithSignedMeterValue_.
     * 
     * 
     */
    @JsonProperty("publicKey")
    @JsonPropertyDescription("*(2.1)* Base64 encoded, sending depends on configuration variable _PublicKeyWithSignedMeterValue_.\r\n")
    @Size(max = 2500)
    private String publicKey;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
