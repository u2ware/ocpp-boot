
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "hashAlgorithm",
    "issuerNameHash",
    "issuerKeyHash",
    "serialNumber",
    "customData"
})
@Generated("jsonschema2pojo")
public class CertificateHashData {

    /**
     * Used algorithms for the hashes provided.
     * 
     * (Required)
     * 
     */
    @JsonProperty("hashAlgorithm")
    @JsonPropertyDescription("Used algorithms for the hashes provided.\r\n")
    @NotNull
    private HashAlgorithmEnum hashAlgorithm;
    /**
     * The hash of the issuer’s distinguished
     * name (DN), that must be calculated over the DER
     * encoding of the issuer’s name field in the certificate
     * being checked.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("issuerNameHash")
    @JsonPropertyDescription("The hash of the issuer\u2019s distinguished\r\nname (DN), that must be calculated over the DER\r\nencoding of the issuer\u2019s name field in the certificate\r\nbeing checked.\r\n\r\n")
    @Size(max = 128)
    @NotNull
    private String issuerNameHash;
    /**
     * The hash of the DER encoded public key:
     * the value (excluding tag and length) of the subject
     * public key field in the issuer’s certificate.
     * 
     * (Required)
     * 
     */
    @JsonProperty("issuerKeyHash")
    @JsonPropertyDescription("The hash of the DER encoded public key:\r\nthe value (excluding tag and length) of the subject\r\npublic key field in the issuer\u2019s certificate.\r\n")
    @Size(max = 128)
    @NotNull
    private String issuerKeyHash;
    /**
     * The string representation of the
     * hexadecimal value of the serial number without the
     * prefix "0x" and without leading zeroes.
     * 
     * (Required)
     * 
     */
    @JsonProperty("serialNumber")
    @JsonPropertyDescription("The string representation of the\r\nhexadecimal value of the serial number without the\r\nprefix \"0x\" and without leading zeroes.\r\n")
    @Size(max = 40)
    @NotNull
    private String serialNumber;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
